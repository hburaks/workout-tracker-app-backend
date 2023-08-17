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
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "workoutTemplateEntity")
    private List<WorkoutExerciseEntity> workoutExerciseList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profileEntity;
}
