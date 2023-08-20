package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapperI;
import com.hbdev.workouttrackerbackend.model.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService extends BaseService<WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO, WorkoutTemplateEntity, WorkoutTemplateMapperI, WorkoutTemplateRepository> {
    private final WorkoutTemplateRepository workoutTemplateRepository;

    @Override
    protected WorkoutTemplateMapperI getBaseMapper() {
        return WorkoutTemplateMapperI.INSTANCE;
    }

    @Override
    protected WorkoutTemplateRepository getBaseRepository() {
        return workoutTemplateRepository;
    }
}

