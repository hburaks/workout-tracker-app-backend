package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutExerciseEntity extends BaseEntity {
    @OneToMany(mappedBy = "workoutExerciseEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SetEntity> setEntities;
    String notes;
    int order;
    int restTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id")
    ExerciseEntity exerciseEntity;

}
