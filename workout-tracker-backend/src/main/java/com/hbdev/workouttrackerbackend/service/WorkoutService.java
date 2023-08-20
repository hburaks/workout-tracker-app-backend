package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService extends BaseService<WorkoutResponseDTO, WorkoutRequestDTO, WorkoutEntity, WorkoutMapper, WorkoutRepository> {

    private final WorkoutRepository workoutRepository;

    @Override
    protected WorkoutMapper getBaseMapper() {
        return WorkoutMapper.INSTANCE;
    }

    @Override
    protected WorkoutRepository getBaseRepository() {
        return workoutRepository;
    }
}
