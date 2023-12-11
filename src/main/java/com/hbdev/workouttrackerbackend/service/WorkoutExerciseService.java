package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.repository.WorkoutExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WorkoutExerciseService extends BaseService<WorkoutExerciseResponseDTO, WorkoutExerciseRequestDTO, PrimitiveExerciseEntity, WorkoutExerciseMapper, WorkoutExerciseRepository, WorkoutExerciseSpecification> {
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutExerciseSpecification workoutExerciseSpecification;


    @Override
    protected WorkoutExerciseMapper getMapper() {
        return WorkoutExerciseMapper.INSTANCE;
    }

    @Override
    protected WorkoutExerciseRepository getRepository() {
        return workoutExerciseRepository;
    }

    @Override
    protected WorkoutExerciseSpecification getSpecification() {
        return workoutExerciseSpecification;
    }
}
