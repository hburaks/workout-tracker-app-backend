package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutExerciseEntity extends BaseEntity {

    private String notes;
    private int setOrder;
    private int restTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id")
    private ExerciseEntity exerciseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_template_id")
    private WorkoutTemplateEntity workoutTemplateEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_entity_id")
    private WorkoutEntity workoutEntity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "workoutExerciseEntity")
    private List<SetEntity> setEntities;

}
