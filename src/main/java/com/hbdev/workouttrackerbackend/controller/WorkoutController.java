package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout")
@RequiredArgsConstructor
public class WorkoutController extends BaseController<WorkoutRequestDTO, WorkoutResponseDTO, WorkoutEntity, WorkoutMapper, WorkoutRepository, WorkoutSpecification, WorkoutService> {
    private final WorkoutService workoutService;

    @Override
    protected WorkoutService getService() {
        return workoutService;
    }
}
