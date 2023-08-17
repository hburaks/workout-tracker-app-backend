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
    String name;
    String description;
    String videoUrl;
    String imageUrl;
    @Enumerated(EnumType.STRING)
    BodyPartTypeEnum bodyPartType;

    @OneToMany(mappedBy = "exerciseEntity", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<WorkoutExerciseEntity> workoutExerciseEntityList;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "max_volume_exercise_id")
    WorkoutExerciseEntity maxVolumeWorkoutExerciseEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "max_weight_set_id")
    SetEntity maxWeightSetEntity;
}
