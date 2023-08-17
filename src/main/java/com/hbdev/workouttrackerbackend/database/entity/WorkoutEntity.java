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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WorkoutExerciseEntity> workoutExerciseList;
    private double totalWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profileEntity;

}
