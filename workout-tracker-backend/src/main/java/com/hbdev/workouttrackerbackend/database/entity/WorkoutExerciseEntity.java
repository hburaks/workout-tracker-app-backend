package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutExerciseEntity extends BaseEntity {
    @OneToMany(mappedBy = "workoutExerciseEntity", fetch = FetchType.LAZY)
    List<SetEntity> setEntities;
    @Column
    String notes;
    @Column
    int order;
    @Column
    int restTime;
    @ManyToOne
    ExerciseEntity exerciseEntity;

}
