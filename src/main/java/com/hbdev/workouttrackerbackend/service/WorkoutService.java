package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.*;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTOWithDbName;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutFinishedResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutStartedResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntityRepository;
import com.hbdev.workouttrackerbackend.util.security.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutService extends BaseService<WorkoutResponseDTO, WorkoutRequestDTO, WorkoutEntity, WorkoutMapper, WorkoutRepository, WorkoutSpecification> {

    private final WorkoutRepository workoutRepository;
    private final WorkoutSpecification workoutSpecification;
    private final UserEntityRepository userEntityRepository;
    private final CustomExerciseService customExerciseService;
    private final UserService userService;
    private final SetService setService;
    private final DefaultExerciseService defaultExerciseService;
    Logger logger = LoggerFactory.getLogger(WorkoutTemplateService.class);


    @Override
    protected WorkoutMapper getMapper() {
        return WorkoutMapper.INSTANCE;
    }

    @Override
    protected WorkoutRepository getRepository() {
        return workoutRepository;
    }

    @Override
    protected WorkoutSpecification getSpecification() {
        return workoutSpecification;
    }

    @Transactional
    public List<WorkoutFinishedResponseDTO> findAllForUser(HttpServletRequest request) {
        UserEntity userEntity = userService.getUser(request);
        return findAll(userEntity);
    }

    public List<WorkoutFinishedResponseDTO> findAll(UserEntity userEntity) {
        List<WorkoutEntity> workoutEntityList = userEntity.getProfile().getWorkoutList();
        if (workoutEntityList != null) {
            return getMapper().entityListToFinishedResponseDto(workoutEntityList);
        } else {
            return new ArrayList<>();
        }
    }


    public WorkoutStartedResponseDTO startWorkoutForUser(UUID uuid, HttpServletRequest request) {
        UserEntity userEntity = userService.getUser(request);
        return startWorkout(uuid, userEntity);
    }

    public WorkoutStartedResponseDTO startWorkout(UUID uuid, UserEntity user) {
        if (user.getProfile().getWorkoutTemplateList().isEmpty()) {
            user.getProfile().setWorkoutTemplateList(new ArrayList<>());
            logger.error("No template for the given uuid");
            return null;
        }
        WorkoutTemplateEntity workoutTemplateEntity = null;
        for (WorkoutTemplateEntity workoutTemplateToLook : user.getProfile().getWorkoutTemplateList()) {
            if (workoutTemplateToLook.getUuid().equals(uuid)) {
                workoutTemplateEntity = workoutTemplateToLook;
                break;
            }
        }
        if (workoutTemplateEntity != null) {
            WorkoutEntity workoutEntity = new WorkoutEntity();
            workoutEntity.setWorkoutTemplate(workoutTemplateEntity);
            workoutEntity.setProfile(user.getProfile());
            workoutEntity.setCustomExerciseList(new ArrayList<>());
            workoutEntity.setStartDate(new Date());

            for (CustomExerciseEntity customExerciseToCopy : workoutTemplateEntity.getCustomExerciseList()) {
                CustomExerciseEntity customExerciseEntity = customExerciseService.createCustomExerciseFromExisting(customExerciseToCopy);
                customExerciseEntity.setWorkout(workoutEntity);
                workoutEntity.getCustomExerciseList().add(customExerciseEntity);
                user.getProfile().getCustomExerciseList().add(customExerciseEntity);
            }

            if (user.getProfile().getWorkoutList() == null) {
                user.getProfile().setWorkoutList(new ArrayList<>());
            }
            user.getProfile().getWorkoutList().add(workoutEntity);

            try {
                UserEntity savedUser = userEntityRepository.saveAndFlush(user);
                int workoutIndex = savedUser.getProfile().getWorkoutList().size() - 1;
                WorkoutEntity savedWorkout = savedUser.getProfile().getWorkoutList().get(workoutIndex);
                logger.info("Workout started for " + savedWorkout);
                return getMapper().entityToStartedResponseDto(savedWorkout);
            } catch (Exception e) {
                logger.error("Can not save the user", e);
                return null;
            }
        } else {
            logger.error("No template for the given uuid");
            return null;
        }

    }

    @Transactional
    public WorkoutFinishedResponseDTO finishWorkoutForUser(UUID uuid, HttpServletRequest request, WorkoutRequestDTO workoutRequestDTO) {
        UserEntity userEntity = userService.getUser(request);
        if (userEntity.getProfile().getWorkoutList().isEmpty()) {
            return null;
        }
        /*
        if (findUnfinishedWorkoutNotTheOneWeWantToFinish(userEntity, uuid)) {
        //TODO: find unfinished workout does not match with uuid and delete it here.
            return null;
        }
        */


        for (WorkoutEntity workoutEntityToLook : userEntity.getProfile().getWorkoutList()) {
            if (workoutEntityToLook.getUuid().equals(uuid) && !workoutEntityToLook.isFinished()) {
                WorkoutEntity workoutEntityToFinish = workoutEntityToLook;

                workoutEntityToFinish.setEndDate(new Date());
                workoutEntityToFinish.setFinished(true);
                Date startDate = workoutEntityToFinish.getStartDate();
                Date endDate = workoutEntityToFinish.getEndDate();
                Integer durationInSecond = calculateTheDurationInSecond(startDate, endDate);
                workoutEntityToFinish.setDurationInSecond(durationInSecond);

                if (workoutEntityToFinish.getCustomExerciseList().isEmpty()) {
                    workoutEntityToFinish.setCustomExerciseList(new ArrayList<>());
                } else {
                    userService.clearCustomExerciseListWithSets(userEntity); //TODO handle clear in here
                    for (CustomExerciseEntity customExercise : workoutEntityToFinish.getCustomExerciseList()) {
                        userEntity.getProfile().getCustomExerciseList().remove(customExercise);
                        customExercise.getSets().clear();
                    }

                    workoutEntityToFinish.getCustomExerciseList().clear();
                }
                for (CustomExerciseRequestDTOWithDbName customExerciseRequestDTOWithDbName : workoutRequestDTO.getCustomExerciseList()) {
                    workoutEntityToFinish = addNewCustomExerciseToWorkout(workoutEntityToFinish, customExerciseRequestDTOWithDbName);
                }
                Double volumeOfWorkout = customExerciseService.calculateVolumeOfCustomExerciseListAndUpdateRm1(workoutEntityToFinish.getCustomExerciseList());
                workoutEntityToFinish.setVolume(volumeOfWorkout);

                if (workoutRequestDTO.isUpdateTemplate()) {
                    updateTemplateFromWorkout(workoutEntityToFinish);
                }
                try {
                    UserEntity savedUser = userEntityRepository.saveAndFlush(userEntity);
                    int workoutIndex = savedUser.getProfile().getWorkoutList().size() - 1;
                    WorkoutEntity savedWorkout = savedUser.getProfile().getWorkoutList().get(workoutIndex);
                    logger.info("Workout finished for " + savedWorkout);
                    return getMapper().entityToFinishedResponseDto(savedWorkout);
                } catch (Exception e) {
                    logger.error("Can not save the user", e);
                    return null;
                }
            }
        }
        return null;
    }

    private boolean findUnfinishedWorkoutNotTheOneWeWantToFinish(UserEntity userEntity, UUID uuid) {
        List<WorkoutEntity> workoutEntityList = userEntity.getProfile().getWorkoutList();
        for (WorkoutEntity workoutEntity : workoutEntityList) {
            if (!workoutEntity.isFinished() && !workoutEntity.getUuid().equals(uuid)) {
                logger.info("Unfinished workout found");
                return true;
            }
        }
        logger.info("No unfinished workout found");
        return false;
    }

    private WorkoutEntity addNewCustomExerciseToWorkout(WorkoutEntity workoutEntity, CustomExerciseRequestDTOWithDbName customExerciseRequestDTOWithDbName) {

        DefaultExerciseEntity defaultExerciseFounded = defaultExerciseService.findDefaultExerciseEntityFromUuid(customExerciseRequestDTOWithDbName.getDefaultExerciseUUID(), workoutEntity.getProfile().getDefaultExerciseList());
        CustomExerciseEntity customExerciseEntity = customExerciseService.createCustomExerciseFromDefaultExercise(defaultExerciseFounded);


        customExerciseEntity = customExerciseService.setRequestVariablesToEntity(customExerciseRequestDTOWithDbName, customExerciseEntity);

        Double volumeOfExercise = setService.calculateVolumeOfSets(customExerciseEntity.getSets());
        customExerciseEntity.setVolume(volumeOfExercise);

        customExerciseEntity.setWorkout(workoutEntity);

        workoutEntity.getCustomExerciseList().add(customExerciseEntity);
        workoutEntity.getProfile().getCustomExerciseList().add(customExerciseEntity);
        return workoutEntity;
    }


    public DefaultExerciseEntity findDefaultExerciseWithNameFromList(String name, List<DefaultExerciseEntity> defaultExerciseEntityList) {
        for (DefaultExerciseEntity defaultExerciseEntity : defaultExerciseEntityList) {
            if (name.equals(defaultExerciseEntity.getDbExercise().getName())) {
                return defaultExerciseEntity;
            }
        }
        logger.error("No exercise named " + name + " find in default exercise list of this profile");
        throw new IllegalStateException("No exercise named " + name + " find in default exercise list of this profile");
    }


    public Integer calculateTheDurationInSecond(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            logger.error("Start date and/or end date are missing for workout.");
            throw new IllegalStateException("Start date and/or end date are missing for workout.");
        }

        long differenceInMilliseconds = endDate.getTime() - startDate.getTime();
        return (int) (differenceInMilliseconds / 1000);
    }

    public void updateTemplateFromWorkout(WorkoutEntity workoutEntity) {
        WorkoutTemplateEntity workoutTemplate = workoutEntity.getWorkoutTemplate();
        for (CustomExerciseEntity customExercise : workoutTemplate.getCustomExerciseList()) {
            workoutTemplate.getProfile().getCustomExerciseList().remove(customExercise);
            customExercise.getSets().clear();
        }

        workoutTemplate.getCustomExerciseList().clear();

        for (CustomExerciseEntity customExerciseToCopy : workoutEntity.getCustomExerciseList()) {
            DefaultExerciseEntity defaultExercise = customExerciseToCopy.getDefaultExercise();
            CustomExerciseEntity customExercise = customExerciseService.createCustomExerciseFromDefaultExercise(defaultExercise);
            if (customExerciseToCopy.getNote() != null) {
                customExercise.setNote(customExerciseToCopy.getNote());
            }
            customExercise.setRestTime(customExerciseToCopy.getRestTime());

            List<SetEntity> copiedSetList = setService.copySetList(customExerciseToCopy.getSets(), customExercise);
            customExercise.getSets().addAll(copiedSetList);

            customExercise.setWorkoutTemplate(workoutEntity.getWorkoutTemplate());

            workoutEntity.getWorkoutTemplate().getCustomExerciseList().add(customExercise);
        }
    }


}
