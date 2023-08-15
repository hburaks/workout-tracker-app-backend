package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Table
@Entity
@Data
public class WorkoutTemplateEntity extends BaseEntity {
    @Column
    String name;
    @OneToMany(mappedBy = "workoutTemplateEntity", fetch = FetchType.LAZY)
    List<WorkoutExerciseEntity> workoutExerciseList;
}
