package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.CustomExerciseRequestForTemplateDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
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
    private final CustomExerciseService customExerciseService;
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


    private CustomExerciseEntity defaultExerciseToCustomExercise(DefaultExerciseEntity defaultExercise) {
        CustomExerciseEntity workoutExercise = new CustomExerciseEntity();
        workoutExercise.setDefaultExercise(defaultExercise);
        return workoutExercise;
    }

    @Transactional
    public WorkoutTemplateResponseDTO createTemplateForUser(WorkoutTemplateRequestDTO workoutTemplateRequestDTO, HttpServletRequest request) {

        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }

        if (userEntity.getProfile().getWorkoutTemplateList().isEmpty()) {
            userEntity.getProfile().setWorkoutTemplateList(new ArrayList<>());
        }

        WorkoutTemplateEntity workoutTemplateEntity = new WorkoutTemplateEntity();
        userEntity.getProfile().getWorkoutTemplateList().add(workoutTemplateEntity);

        workoutTemplateEntity.setName(workoutTemplateRequestDTO.getName());
        List<DefaultExerciseEntity> defaultExerciseEntityList = userEntity.getProfile().getDefaultExerciseList();


        List<CustomExerciseRequestForTemplateDTO> customExerciseRequestForTemplateDTOS = workoutTemplateRequestDTO.getCustomExerciseRequestDTOList();

        for (CustomExerciseRequestForTemplateDTO customExerciseRequestForTemplateDTO : customExerciseRequestForTemplateDTOS) {
            DefaultExerciseEntity defaultExercise = defaultExerciseService.findDefaultExerciseEntityFromUuid(customExerciseRequestForTemplateDTO.getDefaultExerciseUuid(), defaultExerciseEntityList);
            CustomExerciseEntity customExercise = customExerciseService.createCustomExerciseFromDefaultExercise(defaultExercise);

            customExercise.setNote(customExerciseRequestForTemplateDTO.getNote());
            customExercise.setRestTime(customExerciseRequestForTemplateDTO.getRestTime());
            customExercise.getSets().addAll(setService.requestListToEntityList(customExerciseRequestForTemplateDTO.getSets()));

            workoutTemplateEntity.getCustomExerciseList().add(customExercise);
        }
        try {
            userEntityRepository.save(userEntity);

        } catch (Exception e) {
            logger.error("Can not save the user", e);
        }

        return getMapper().entityToResponseDto(workoutTemplateEntity);
    }
}

