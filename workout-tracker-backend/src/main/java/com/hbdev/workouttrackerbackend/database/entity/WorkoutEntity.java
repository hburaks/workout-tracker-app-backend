package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutEntity extends BaseEntity {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String notes;
    private int duration;


    private double totalWeight;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "workoutEntity")
    private List<WorkoutExerciseEntity> workoutExerciseList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profileEntity;

}
