package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTOWithDbName;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
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
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService extends BaseService<WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification> {
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final UserEntityRepository userEntityRepository;
    private final WorkoutTemplateSpecification workoutTemplateSpecification;
    private final UserService userService;
    private final WorkoutService workoutService;
    private final CustomExerciseService customExerciseService;
    private final DefaultExerciseService defaultExerciseService;

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



    @Transactional
    public List<WorkoutTemplateInProfileResponseDTO> createTemplateForUser(WorkoutTemplateRequestDTO workoutTemplateRequestDTO, HttpServletRequest request) {
        UserEntity userEntity = userService.getUser(request);
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


        List<CustomExerciseRequestDTOWithDbName> customExerciseRequestDTOWithDbNameList = workoutTemplateRequestDTO.getCustomExerciseList();


        for (CustomExerciseRequestDTOWithDbName customExerciseRequestDTOWithDbName : customExerciseRequestDTOWithDbNameList) {
            DefaultExerciseEntity defaultExerciseFounded = defaultExerciseService.findDefaultExerciseEntityFromUuid(customExerciseRequestDTOWithDbName.getDefaultExerciseUUID(), defaultExerciseEntityList);
            CustomExerciseEntity customExercise = customExerciseService.createCustomExerciseFromDefaultExercise(defaultExerciseFounded);


            customExerciseService.setRequestVariablesToEntity(customExerciseRequestDTOWithDbName, customExercise);


            userEntity.getProfile().getCustomExerciseList().add(customExercise);
            workoutTemplateEntity.getCustomExerciseList().add(customExercise);

            customExercise.setWorkoutTemplate(workoutTemplateEntity);
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


    @Transactional
    public List<WorkoutTemplateInProfileResponseDTO> findAllForUser(HttpServletRequest request) {
        UserEntity userEntity = userService.getUser(request);
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

