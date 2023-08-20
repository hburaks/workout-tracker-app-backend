package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutExerciseMapperI;
import com.hbdev.workouttrackerbackend.model.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.service.WorkoutExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-exercise")
@RequiredArgsConstructor
public class WorkoutExerciseController extends BaseController<WorkoutExerciseRequestDTO, WorkoutExerciseResponseDTO,
        WorkoutExerciseEntity,
        WorkoutExerciseMapperI,
        WorkoutExerciseRepository,
        WorkoutExerciseService> {
    private final WorkoutExerciseService workoutExerciseService;


    @Override
    protected WorkoutExerciseService getService() {
        return workoutExerciseService;
    }
}
