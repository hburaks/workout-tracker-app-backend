package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.*;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.CustomExerciseRequestForTemplateDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.security.JWTUtil;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntityRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService extends BaseService<WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification> {
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final UserEntityRepository userEntityRepository;
    private final DefaultExerciseService defaultExerciseService;
    private final WorkoutTemplateSpecification workoutTemplateSpecification;
    private final SetService setService;
    private final JWTUtil jwtUtil;

    Logger logger = LoggerFactory.getLogger(WorkoutTemplateService.class);

    @Override
    protected WorkoutTemplateMapper getMapper() {
        return WorkoutTemplateMapper.INSTANCE;
    }

    @Override
    protected WorkoutTemplateRepository getRepository() {
        return workoutTemplateRepository;
    }

    @Override
    protected WorkoutTemplateSpecification getSpecification() {
        return workoutTemplateSpecification;
    }


    public CustomExerciseEntity defaultExerciseToCustomExercise(DefaultExerciseEntity defaultExercise) {
        CustomExerciseEntity workoutExercise = new CustomExerciseEntity();
        workoutExercise.setName(defaultExercise.getDbExercise().getName());
        workoutExercise.setDefaultExercise(defaultExercise);
        workoutExercise.setProfile(defaultExercise.getProfile());
        workoutExercise.setSets(new ArrayList<>());
        return workoutExercise;
    }

    @Transactional
    public List<WorkoutTemplateInProfileResponseDTO> createTemplateForUser(WorkoutTemplateRequestDTO workoutTemplateRequestDTO, HttpServletRequest request) {

        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }
        return createTemplate(workoutTemplateRequestDTO, userEntity);
    }

    public List<WorkoutTemplateInProfileResponseDTO> createTemplate(WorkoutTemplateRequestDTO workoutTemplateRequestDTO, UserEntity userEntity) {
        if (userEntity.getProfile().getWorkoutTemplateList().isEmpty()) {
            userEntity.getProfile().setWorkoutTemplateList(new ArrayList<>());
        }

        WorkoutTemplateEntity workoutTemplateEntity = new WorkoutTemplateEntity();
        userEntity.getProfile().getWorkoutTemplateList().add(workoutTemplateEntity);

        workoutTemplateEntity.setName(workoutTemplateRequestDTO.getName());
        workoutTemplateEntity.setCustomExerciseList(new ArrayList<>());
        workoutTemplateEntity.setProfile(userEntity.getProfile());
        List<DefaultExerciseEntity> defaultExerciseEntityList = userEntity.getProfile().getDefaultExerciseList();


        List<CustomExerciseRequestForTemplateDTO> customExerciseRequestForTemplateDTOS = workoutTemplateRequestDTO.getCustomExerciseRequestDTOList();

        for (CustomExerciseRequestForTemplateDTO customExerciseRequestForTemplateDTO : customExerciseRequestForTemplateDTOS) {

            DefaultExerciseEntity defaultExercise = defaultExerciseService.findDefaultExerciseEntityFromUuid(customExerciseRequestForTemplateDTO.getDefaultExerciseUuid(), defaultExerciseEntityList);

            CustomExerciseEntity customExercise = defaultExerciseToCustomExercise(defaultExercise);
            customExercise.setNote(customExerciseRequestForTemplateDTO.getNote());
            customExercise.setRestTime(customExerciseRequestForTemplateDTO.getRestTime());
            List<SetEntity> setEntityList = setService.requestListToEntityList(customExerciseRequestForTemplateDTO.getSets());
            for (SetEntity set : setEntityList) {
                set.setCustomExercise(customExercise);
                customExercise.getSets().add(set);
            }
            customExercise.setWorkoutTemplate(workoutTemplateEntity);

            userEntity.getProfile().getCustomExerciseList().add(customExercise);
            workoutTemplateEntity.getCustomExerciseList().add(customExercise);
        }
        try {
            UserEntity savedUser = userEntityRepository.saveAndFlush(userEntity);
            logger.info("Workout created");
            return getMapper().entityListToResponseDtoListInProfile(savedUser.getProfile().getWorkoutTemplateList());
        } catch (Exception e) {
            logger.error("Can not save the user", e);
        }
        return null;
    }

    public void updateTemplateFromWorkout(WorkoutEntity workoutEntity) {
        workoutEntity.getWorkoutTemplate().setCustomExerciseList(new ArrayList<>());
        for (CustomExerciseEntity customExerciseEntity : workoutEntity.getCustomExerciseList()) {
            DefaultExerciseEntity defaultExercise = customExerciseEntity.getDefaultExercise();
            CustomExerciseEntity customExercise = defaultExerciseToCustomExercise(defaultExercise);
            customExercise.setNote(customExerciseEntity.getNote());
            customExercise.setRestTime(customExerciseEntity.getRestTime());
            customExercise.getSets().addAll(customExerciseEntity.getSets());
            customExercise.setWorkoutTemplate(customExerciseEntity.getWorkoutTemplate());
            workoutEntity.getWorkoutTemplate().getCustomExerciseList().add(customExercise);
        }
    }

    @Transactional
    public List<WorkoutTemplateInProfileResponseDTO> findAllForUser(HttpServletRequest request) {
        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }
        return findAll(userEntity);
    }

    public List<WorkoutTemplateInProfileResponseDTO> findAll(UserEntity userEntity) {
        List<WorkoutTemplateEntity> workoutTemplateEntityList = userEntity.getProfile().getWorkoutTemplateList();
        if (workoutTemplateEntityList != null) {
            return getMapper().listToResponseList(workoutTemplateEntityList);
        } else {
            return new ArrayList<>();
        }
    }

}

