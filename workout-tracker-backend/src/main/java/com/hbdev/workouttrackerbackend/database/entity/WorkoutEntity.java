package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class WorkoutEntity extends BaseEntity {
    @Column
    String name;
    @Column
    String imageUrl;
    @Column
    String videoUrl;
    @Column
    String notes;
    @Column
    int duration;
    @OneToMany(mappedBy = "workoutEntity", fetch = FetchType.LAZY)
    List<WorkoutExerciseEntity> workoutExerciseList;
    @Column
    double totalWeight;

}
