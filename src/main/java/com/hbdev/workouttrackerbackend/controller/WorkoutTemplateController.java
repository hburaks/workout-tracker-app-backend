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

    @PostMapping("{templateUuid}/toAdd/{exerciseUuid}")
    public ResponseEntity<WorkoutTemplateResponseDTO> add(@PathVariable UUID templateUuid, @PathVariable UUID exerciseUuid) {
        WorkoutTemplateResponseDTO responseDTO = getService().add(templateUuid, exerciseUuid);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
