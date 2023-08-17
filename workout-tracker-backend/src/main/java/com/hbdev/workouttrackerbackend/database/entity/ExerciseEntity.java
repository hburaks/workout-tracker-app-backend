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
    private String name;
    private String description;
    private String videoUrl;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private BodyPartTypeEnum bodyPartType;

    @OneToMany(mappedBy = "exerciseEntity", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<WorkoutExerciseEntity> workoutExerciseEntityList;

    @OneToOne(cascade = CascadeType.PERSIST)
    private WorkoutExerciseEntity maxVolumeWorkoutExerciseEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    private SetEntity maxWeightSetEntity;
}
