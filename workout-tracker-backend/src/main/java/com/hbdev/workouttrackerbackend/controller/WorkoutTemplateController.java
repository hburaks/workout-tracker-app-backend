package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapperI;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.service.ExerciseService;
import com.hbdev.workouttrackerbackend.service.WorkoutService;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-template")
public class WorkoutTemplateController extends BaseController<WorkoutTemplateRequestDTO, WorkoutTemplateResponseDTO,
        WorkoutTemplateEntity,
        WorkoutTemplateMapperI,
        WorkoutTemplateRepository,
        WorkoutTemplateService> {
    @Autowired
    WorkoutTemplateService workoutTemplateService;


    @Override
    protected WorkoutTemplateService getService() {
        return workoutTemplateService;
    }
}
