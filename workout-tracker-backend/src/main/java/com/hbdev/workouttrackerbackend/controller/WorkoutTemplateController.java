package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("workout-template")
@RequiredArgsConstructor
public class WorkoutTemplateController extends BaseController<WorkoutTemplateRequestDTO, WorkoutTemplateResponseDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification, WorkoutTemplateService> {
    private final WorkoutTemplateService workoutTemplateService;


    @Override
    protected WorkoutTemplateService getService() {
        return workoutTemplateService;
    }

    @PostMapping("{uuid}/toAdd/{uuidToAdd}")
    public ResponseEntity<Boolean> add(@PathVariable UUID uuid, @PathVariable UUID uuidToAdd) {
        try {
            WorkoutTemplateResponseDTO responseDTO = getService().add(uuid, uuidToAdd);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
