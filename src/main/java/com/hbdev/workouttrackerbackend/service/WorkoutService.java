package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapperI;
import com.hbdev.workouttrackerbackend.model.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService extends BaseService<WorkoutResponseDTO, WorkoutRequestDTO, WorkoutEntity, WorkoutMapperI, WorkoutRepository> {

    private final WorkoutRepository workoutRepository;

    @Override
    protected WorkoutMapperI getBaseMapper() {
        return WorkoutMapperI.INSTANCE;
    }

    @Override
    protected WorkoutRepository getBaseRepository() {
        return workoutRepository;
    }
}
