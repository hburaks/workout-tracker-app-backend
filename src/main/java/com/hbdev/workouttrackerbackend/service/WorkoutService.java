package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutSpecification;
import com.hbdev.workouttrackerbackend.mapper.SetMapper;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutFinishedResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutStartedResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.security.JWTUtil;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final JWTUtil jwtUtil;
    private final CustomExerciseService customExerciseService;
    private final WorkoutTemplateService workoutTemplateService;
    private final UserService userService;
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

    public WorkoutStartedResponseDTO startWorkoutForUser(UUID uuid, HttpServletRequest request) {
        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }

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
            }
        }
        if (workoutTemplateEntity != null) {
            WorkoutEntity workoutEntity = new WorkoutEntity();
            workoutEntity.setWorkoutTemplate(workoutTemplateEntity);
            workoutEntity.setProfile(user.getProfile());
            workoutEntity.setCustomExerciseList(new ArrayList<>());
            for (CustomExerciseEntity customExercise : workoutTemplateEntity.getCustomExerciseList()) {
                CustomExerciseEntity customExerciseEntity = new CustomExerciseEntity(customExercise);
                customExerciseEntity.setWorkout(workoutEntity);
                workoutEntity.getCustomExerciseList().add(customExerciseEntity);
            }

            return getMapper().entityToStartedResponseDto(workoutEntity);
        } else {
            logger.error("No template for the given uuid");
            return null;
        }

    }

    public WorkoutFinishedResponseDTO finishWorkoutForUser(UUID uuid, HttpServletRequest request, WorkoutRequestDTO workoutRequestDTO) {
        UserEntity userEntity = userService.getUser(request);
        WorkoutEntity workoutEntity;
        if (userEntity.getProfile().getWorkoutList().isEmpty()) {
            return null;
        }
        if (hasUserUnfinishedWorkouts(userEntity, uuid)) {
            return null;
        }


        for (WorkoutEntity workoutEntityToLook : userEntity.getProfile().getWorkoutList()) {
            if (workoutEntityToLook.getUuid().equals(uuid)) {
                workoutEntity = workoutEntityToLook;

                setTheDurationInSecond(workoutEntity);
                workoutEntity.setFinished(true);
                workoutEntity.setEndDate(new Date());
                workoutEntity.setCustomExerciseList(new ArrayList<>());
                for (CustomExerciseRequestDTO customExerciseRequestDTO : workoutRequestDTO.getCustomExerciseList()) {
                    workoutEntity = addCustomExerciseRequestToWorkout(workoutEntity, customExerciseRequestDTO);
                }
                calculateVolumeOfWorkout(workoutEntity);

                if (workoutRequestDTO.isUpdateTemplate()) {
                    workoutTemplateService.updateTemplateFromWorkout(workoutEntity);
                }
                return getMapper().entityToFinishedResponseDto(workoutEntity);
            }
        }
        return null;
    }

    private boolean hasUserUnfinishedWorkouts(UserEntity userEntity, UUID uuid) {
        List<WorkoutEntity> workoutEntityList = userEntity.getProfile().getWorkoutList();
        for (WorkoutEntity workoutEntity : workoutEntityList) {
            if (!workoutEntity.isFinished() && !workoutEntity.getUuid().equals(uuid)) {
                return true;
            }
        }

        return false;
    }

    private WorkoutEntity addCustomExerciseRequestToWorkout(WorkoutEntity workoutEntity, CustomExerciseRequestDTO customExerciseRequestDTO) {
        DefaultExerciseEntity defaultExerciseFounded = findCustomExerciseFromDefaultExercises(customExerciseRequestDTO.getName(), workoutEntity.getProfile().getDefaultExerciseList());
        CustomExerciseEntity customExerciseEntity = workoutTemplateService.defaultExerciseToCustomExercise(defaultExerciseFounded);
        if (customExerciseRequestDTO.isNoteForGeneral()) {
            customExerciseEntity.getDefaultExercise().setNote(customExerciseRequestDTO.getNote());
        } else {
            customExerciseEntity.setNote(customExerciseRequestDTO.getNote());
        }
        customExerciseEntity.setSets(SetMapper.INSTANCE.requestListToEntityList(customExerciseRequestDTO.getSets()));
        double volumeOfExercise = customExerciseService.calculateVolumeOfCustomExercise(customExerciseEntity);
        customExerciseEntity.setVolume(volumeOfExercise);
        customExerciseEntity.setRestTime(customExerciseRequestDTO.getRestTime());
        customExerciseEntity.setWorkout(workoutEntity);
        customExerciseEntity.setWorkoutTemplate(workoutEntity.getWorkoutTemplate());
        workoutEntity.getCustomExerciseList().add(customExerciseEntity);
        return workoutEntity;
    }


 /*   private void updateCustomExercisesInWorkout(WorkoutEntity workoutEntity, WorkoutRequestDTO workoutRequestDTO) {
        for (int i = 0; i < workoutEntity.getCustomExerciseList().size(); i++) {
            CustomExerciseEntity customExerciseEntity = workoutEntity.getCustomExerciseList().get(i);
            boolean isExercisePresent = updateExerciseEntityWithRequest(workoutRequestDTO, customExerciseEntity);
            //TODO should you return those entities or hashing works?
            if (!isExercisePresent) {
                workoutEntity.getCustomExerciseList().remove(i);
                i--;
            }
        }
        for (int i = 0; i < workoutRequestDTO.getCustomExerciseList().size(); i++) {
            CustomExerciseRequestDTO customExerciseRequestDTO = workoutRequestDTO.getCustomExerciseList().get(i);
            addCustomExerciseToWorkoutIfNotExistInTemplate(workoutEntity, customExerciseRequestDTO);
            //TODO: why tried to return boolean for it
        }
    }*/


/*    private void addCustomExerciseToWorkoutIfNotExistInTemplate(WorkoutEntity workoutEntity, CustomExerciseRequestDTO customExerciseRequestDTO) {
        boolean isExercisePresent = false;
        for (CustomExerciseEntity customExerciseEntity : workoutEntity.getCustomExerciseList()) {
            if (customExerciseRequestDTO.getName().equals(customExerciseEntity.getName())) {
                isExercisePresent = true;
            }
        }
        if (!isExercisePresent) {
            DefaultExerciseEntity defaultExerciseFounded = findCustomExerciseFromDefaultExercises(customExerciseRequestDTO.getName(), workoutEntity.getProfile().getDefaultExerciseList());
            CustomExerciseEntity customExerciseEntity = workoutTemplateService.defaultExerciseToCustomExercise(defaultExerciseFounded);
            if (customExerciseRequestDTO.isNoteForGeneral()) {
                customExerciseEntity.getDefaultExercise().setNote(customExerciseRequestDTO.getNote());
            } else {
                customExerciseEntity.setNote(customExerciseRequestDTO.getNote());
            }
            customExerciseEntity.setSets(SetMapper.INSTANCE.requestListToEntityList(customExerciseRequestDTO.getSets()));
            customExerciseEntity.setRestTime(customExerciseRequestDTO.getRestTime());
            customExerciseEntity.setWorkout(workoutEntity);
            customExerciseEntity.setWorkoutTemplate(workoutEntity.getWorkoutTemplate());
            workoutEntity.getCustomExerciseList().add(customExerciseEntity);
        }
    }*/

    private DefaultExerciseEntity findCustomExerciseFromDefaultExercises(String name, List<DefaultExerciseEntity> defaultExerciseEntityList) {
        for (DefaultExerciseEntity defaultExerciseEntity : defaultExerciseEntityList) {
            if (name.equals(defaultExerciseEntity.getDbExercise().getName())) {
                return defaultExerciseEntity;
            }
        }
        logger.error("No exercise named " + name + " find in default exercise list of this profile");
        return null;
    }


/*    private boolean updateExerciseEntityWithRequest(WorkoutRequestDTO workoutRequestDTO, CustomExerciseEntity customExerciseEntity) {
        boolean isExercisePresent = false;
        for (CustomExerciseRequestDTO customExerciseRequestDTO : workoutRequestDTO.getCustomExerciseList()) {
            if (customExerciseRequestDTO.getName().equals(customExerciseEntity.getName())) {
                isExercisePresent = true;
                if (customExerciseRequestDTO.isNoteForGeneral()) {
                    customExerciseEntity.getDefaultExercise().setNote(customExerciseRequestDTO.getNote());
                } else {
                    customExerciseEntity.setNote(customExerciseRequestDTO.getNote());
                }
                customExerciseEntity.setSets(SetMapper.INSTANCE.requestListToEntityList(customExerciseRequestDTO.getSets()));
                customExerciseEntity.setRestTime(customExerciseRequestDTO.getRestTime());
            }
        }
        return isExercisePresent;
    }*/


    private void setTheDurationInSecond(WorkoutEntity workoutEntity) {
        Date startDate = workoutEntity.getStartDate();
        Date endDate = workoutEntity.getEndDate();
        if (startDate != null && endDate != null) {
            long differenceInMilliseconds = endDate.getTime() - startDate.getTime();
            int durationInSeconds = (int) (differenceInMilliseconds / 1000);
            workoutEntity.setDurationInSecond(durationInSeconds);
        }

    }

    private void calculateVolumeOfWorkout(WorkoutEntity workout) {
        double volumeOfWorkout = 0;
        for (CustomExerciseEntity customExercise : workout.getCustomExerciseList()) {
            volumeOfWorkout += customExercise.getVolume();
        }
        workout.setVolume(volumeOfWorkout);
    }
}
