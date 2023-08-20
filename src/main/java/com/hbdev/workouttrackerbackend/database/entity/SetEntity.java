package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class SetEntity extends BaseEntity {
    private double weight;
    private int reps;
    private int setOrder;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id")
    WorkoutExerciseEntity workoutExercise;
}
