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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    @Transactional
    public WorkoutTemplateResponseDTO add(UUID uuid, UUID uuidToAdd) {
        ExerciseEntity exercise = exerciseService.getEntityByUuid(uuidToAdd);
        WorkoutTemplateEntity workoutTemplate = getEntityByUuid(uuid);


        WorkoutExerciseEntity workoutExercise = exerciseToWorkoutExercise(exercise);
        workoutExercise.setWorkoutTemplate(workoutTemplate);
        if(workoutTemplate.getWorkoutExerciseList() == null){
            workoutTemplate.setWorkoutExerciseList(new ArrayList<>());
        }
        workoutTemplate.getWorkoutExerciseList().add(workoutExercise);

        workoutTemplate = workoutTemplateRepository.save(workoutTemplate);

        return getBaseMapper().entityToResponseDto(workoutTemplate);

    }

    private WorkoutExerciseEntity exerciseToWorkoutExercise(ExerciseEntity exercise) {
        WorkoutExerciseEntity workoutExercise = new WorkoutExerciseEntity();
        workoutExercise.setExercise(exercise);
        return workoutExercise;
    }
}

