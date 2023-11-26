package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExercisePersonalRecordEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
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
    private final ExerciseService exerciseService;
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
    public WorkoutTemplateResponseDTO add(UUID uuid, UUID uuidToAdd) {
        ExercisePersonalRecordEntity exercise = exerciseService.getEntityByUuid(uuidToAdd);
        WorkoutTemplateEntity workoutTemplate = getEntityByUuid(uuid);
        if (workoutTemplate != null && exercise != null) {
            WorkoutExerciseEntity workoutExercise = exerciseToWorkoutExercise(exercise);
            workoutExercise.setWorkoutTemplate(workoutTemplate);
            if (workoutTemplate.getWorkoutExerciseList() == null) {
                workoutTemplate.setWorkoutExerciseList(new ArrayList<>());
            }
            workoutTemplate.getWorkoutExerciseList().add(workoutExercise);
            workoutTemplate = workoutTemplateRepository.save(workoutTemplate);
            return getMapper().entityToResponseDto(workoutTemplate);
        }
        return null;
    }

    private WorkoutExerciseEntity exerciseToWorkoutExercise(ExercisePersonalRecordEntity exercise) {
        WorkoutExerciseEntity workoutExercise = new WorkoutExerciseEntity();
        workoutExercise.setExercise(exercise);
        return workoutExercise;
    }

}

