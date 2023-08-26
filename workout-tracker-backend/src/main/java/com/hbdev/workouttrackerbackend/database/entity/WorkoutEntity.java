package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutEntity extends BaseEntity {
    private String notes;
    private int duration;
    private double totalWeight;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "workout")
    private List<WorkoutExerciseEntity> workoutExerciseList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private WorkoutTemplateEntity workoutTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

}
