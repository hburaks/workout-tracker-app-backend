package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

public class SetRequestDTO extends BaseEntity {

    private double weight;
    private int reps;
    private int setOrder;


    WorkoutExerciseEntity workoutExerciseEntity;
}
