package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-template")
@RequiredArgsConstructor
public class WorkoutTemplateController extends BaseController<WorkoutTemplateRequestDTO, WorkoutTemplateResponseDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification, WorkoutTemplateService> {
    private final WorkoutTemplateService workoutTemplateService;

    @Override
    protected WorkoutTemplateService getService() {
        return workoutTemplateService;
    }

    @PostMapping("create-template")
    public ResponseEntity<WorkoutTemplateResponseDTO> createTemplate(@RequestBody WorkoutTemplateRequestDTO workoutTemplateRequestDTO, HttpServletRequest request) {
        WorkoutTemplateResponseDTO responseDTO = getService().createTemplateForUser(workoutTemplateRequestDTO, request);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
