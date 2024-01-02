package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutTemplateRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutTemplateSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutTemplateMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutTemplateService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workout-template")
@RequiredArgsConstructor
@Slf4j
public class WorkoutTemplateController extends BaseController<WorkoutTemplateRequestDTO, WorkoutTemplateResponseDTO, WorkoutTemplateEntity, WorkoutTemplateMapper, WorkoutTemplateRepository, WorkoutTemplateSpecification, WorkoutTemplateService> {
    private final WorkoutTemplateService workoutTemplateService;

    @Override
    protected WorkoutTemplateService getService() {
        return workoutTemplateService;
    }

    @PostMapping("create-template")
    public ResponseEntity<List<WorkoutTemplateInProfileResponseDTO>> createTemplate(@RequestBody WorkoutTemplateRequestDTO workoutTemplateRequestDTO, HttpServletRequest request) {
        List<WorkoutTemplateInProfileResponseDTO> responseDTO = getService().createTemplateForUser(workoutTemplateRequestDTO, request);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<List<WorkoutTemplateInProfileResponseDTO>> findAll(HttpServletRequest request) {
        List<WorkoutTemplateInProfileResponseDTO> workoutTemplateList = workoutTemplateService.findAllForUser(request);
        return new ResponseEntity<>(workoutTemplateList, HttpStatus.OK);
    }
}
