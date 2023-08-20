package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapperI;
import com.hbdev.workouttrackerbackend.model.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-template")
@RequiredArgsConstructor
public class WorkoutTemplateController extends BaseController<WorkoutTemplateRequestDTO, WorkoutTemplateResponseDTO, WorkoutTemplateEntity, WorkoutTemplateMapperI, WorkoutTemplateRepository, WorkoutTemplateService> {
    private final WorkoutTemplateService workoutTemplateService;


    @Override
    protected WorkoutTemplateService getService() {
        return workoutTemplateService;
    }
}
