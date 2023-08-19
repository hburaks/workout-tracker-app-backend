package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;

public class SetRequestDTO extends BaseRequestDTO {

    private double weight;
    private int reps;
    private int setOrder;


    WorkoutExerciseEntity workoutExerciseEntity;
}
