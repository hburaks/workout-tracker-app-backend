package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class WorkoutService extends BaseService<WorkoutResponseDTO, WorkoutExerciseRequestDTO, WorkoutEntity, WorkoutMapper, WorkoutRepository> {
    @Autowired
    WorkoutRepository workoutRepository;

    @Override
    protected WorkoutMapper getBaseMapper() {
        return WorkoutMapper.INSTANCE;
    }

    @Override
    protected WorkoutRepository getBaseRepository() {
        return workoutRepository;
    }
}
