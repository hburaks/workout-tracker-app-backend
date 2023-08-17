package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

public class SetResponseDTO extends BaseEntity {

    private double weight;
    private int reps;
    private int setOrder;


    WorkoutExerciseEntity workoutExerciseEntity;
}
