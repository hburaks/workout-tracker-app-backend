package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class ExerciseEntity extends BaseEntity {
    @Column
    String name;
    @Column
    String description;
    @Column
    String videoUrl;
    @Column
    String imageUrl;
    @Enumerated(EnumType.STRING)
    BodyPartTypeEnum bodyPartType;
    @OneToMany(mappedBy = "exerciseEntity", fetch = FetchType.LAZY)
    List<WorkoutExerciseEntity> workoutExerciseEntityList;
    @OneToOne
    WorkoutExerciseEntity maxVolumeWorkoutExerciseEntity;
    @OneToOne
    SetEntity maxWeightSetEntity;
}
