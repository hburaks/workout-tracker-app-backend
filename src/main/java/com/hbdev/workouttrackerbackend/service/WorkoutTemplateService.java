package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService extends BaseService<WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification> {
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final DefaultExerciseService defaultExerciseService;
    private final WorkoutTemplateSpecification workoutTemplateSpecification;

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
    public WorkoutTemplateResponseDTO addDefaultExerciseToTemplate(UUID uuid, UUID uuidToAdd) {
        DefaultExerciseEntity defaultExercise = defaultExerciseService.getEntityByUuid(uuidToAdd);
        WorkoutTemplateEntity workoutTemplate = getEntityByUuid(uuid);
        if (workoutTemplate != null && defaultExercise != null) {
            // TODO:   workoutExercise.setWorkoutTemplate(workoutTemplate); Otomatik persist oluyor mu db kontrolü yapılmalı
            if (workoutTemplate.getDefaultExerciseList() == null) {
                workoutTemplate.setDefaultExerciseList(new ArrayList<>());
            }
            workoutTemplate.getDefaultExerciseList().add(defaultExercise);
            workoutTemplate = workoutTemplateRepository.save(workoutTemplate);
            return getMapper().entityToResponseDto(workoutTemplate);
        }
        return null;
    }

    private CustomExerciseEntity defaultExerciseToCustomExercise(DefaultExerciseEntity defaultExercise) {
        CustomExerciseEntity workoutExercise = new CustomExerciseEntity();
        workoutExercise.setDefaultExercise(defaultExercise);
        return workoutExercise;
    }
}

