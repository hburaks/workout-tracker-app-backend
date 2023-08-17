package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutEntity extends BaseEntity {
    String name;
    String imageUrl;
    String videoUrl;
    String notes;
    @Column
    int duration;
    @OneToMany(mappedBy = "workoutEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<WorkoutExerciseEntity> workoutExerciseList;
    double totalWeight;

}
