package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WorkoutExerciseService extends BaseService<WorkoutExerciseResponseDTO, WorkoutExerciseRequestDTO, WorkoutExerciseEntity, WorkoutExerciseMapper, WorkoutExerciseRepository> {
    private final WorkoutExerciseRepository workoutExerciseRepository;


    @Override
    protected WorkoutExerciseMapper getBaseMapper() {
        return WorkoutExerciseMapper.INSTANCE;
    }

    @Override
    protected WorkoutExerciseRepository getBaseRepository() {
        return workoutExerciseRepository;
    }
}
