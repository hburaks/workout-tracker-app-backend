package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.WorkoutExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.WorkoutExerciseMapperI;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.service.ExerciseService;
import com.hbdev.workouttrackerbackend.service.WorkoutExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-exercise")
public class WorkoutExerciseController extends BaseController<WorkoutExerciseRequestDTO, WorkoutExerciseResponseDTO,
        WorkoutExerciseEntity,
        WorkoutExerciseMapperI,
        WorkoutExerciseRepository,
        WorkoutExerciseService> {
    @Autowired
    WorkoutExerciseService workoutExerciseService;


    @Override
    protected WorkoutExerciseService getService() {
        return workoutExerciseService;
    }
}
