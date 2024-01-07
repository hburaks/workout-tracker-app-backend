package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutRepository;
import com.hbdev.workouttrackerbackend.database.specification.WorkoutSpecification;
import com.hbdev.workouttrackerbackend.mapper.WorkoutMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutFinishedResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutStartedResponseDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("workout")
@RequiredArgsConstructor
public class WorkoutController extends BaseController<WorkoutRequestDTO, WorkoutResponseDTO, WorkoutEntity, WorkoutMapper, WorkoutRepository, WorkoutSpecification, WorkoutService> {
    private final WorkoutService workoutService;

    @Override
    protected WorkoutService getService() {
        return workoutService;
    }

    @PostMapping("start-workout/{uuid}")
    public ResponseEntity<WorkoutStartedResponseDTO> createWorkout(@PathVariable UUID uuid, HttpServletRequest request) {
        WorkoutStartedResponseDTO responseDTO = getService().startWorkoutForUser(uuid, request);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("finish-workout/{uuid}")
    public ResponseEntity<WorkoutFinishedResponseDTO> finishWorkout(@PathVariable UUID uuid, @RequestBody WorkoutRequestDTO requestDTO, HttpServletRequest request) {
        WorkoutFinishedResponseDTO responseDTO = getService().finishWorkoutForUser(uuid, request, requestDTO);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find-all")
    public ResponseEntity<List<WorkoutFinishedResponseDTO>> findAll(HttpServletRequest request) {
        List<WorkoutFinishedResponseDTO> workoutTemplateList = workoutService.findAllForUser(request);
        return new ResponseEntity<>(workoutTemplateList, HttpStatus.OK);
    }

}
