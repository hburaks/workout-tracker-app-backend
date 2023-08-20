package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService extends BaseService<WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository> {
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final ExerciseService exerciseService;
    private final WorkoutExerciseService workoutExerciseService;

    @Override
    protected WorkoutTemplateMapper getBaseMapper() {
        return WorkoutTemplateMapper.INSTANCE;
    }

    @Override
    protected WorkoutTemplateRepository getBaseRepository() {
        return workoutTemplateRepository;
    }

    public WorkoutTemplateResponseDTO add(UUID uuid, UUID uuidToAdd) {
// TODO NOT SAVING TO DB
        ExerciseEntity exercise = exerciseService.getEntityByUuid(uuidToAdd);
        WorkoutTemplateEntity workoutTemplate = getEntityByUuid(uuid);
        WorkoutExerciseEntity workoutExerciseEntity = exerciseToWorkoutExercise(exercise);
        workoutTemplate.getWorkoutExerciseList().add(workoutExerciseEntity);
        return getBaseMapper().entityToResponseDto(workoutTemplateRepository.save(workoutTemplate));

    }

    private WorkoutExerciseEntity exerciseToWorkoutExercise(ExerciseEntity exercise) {
        WorkoutExerciseEntity workoutExercise = new WorkoutExerciseEntity();
        workoutExercise.setExercise(exercise);
        return workoutExercise;
    }
}

