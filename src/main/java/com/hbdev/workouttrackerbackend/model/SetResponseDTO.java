package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;

public class SetResponseDTO extends BaseResponseDTO {

    private double weight;
    private int reps;
    private int setOrder;


    WorkoutExerciseEntity workoutExerciseEntity;
}
