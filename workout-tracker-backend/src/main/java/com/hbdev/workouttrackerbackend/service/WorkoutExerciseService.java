package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutExerciseMapperI;
import com.hbdev.workouttrackerbackend.model.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Data
public class WorkoutExerciseService extends BaseService<WorkoutExerciseResponseDTO, WorkoutExerciseRequestDTO, WorkoutExerciseEntity, WorkoutExerciseMapperI, WorkoutExerciseRepository> {
    @Autowired
    WorkoutExerciseRepository workoutExerciseRepository;


    @Override
    protected WorkoutExerciseMapperI getBaseMapper() {
        return WorkoutExerciseMapperI.INSTANCE;
    }

    @Override
    protected WorkoutExerciseRepository getBaseRepository() {
        return workoutExerciseRepository;
    }
}
