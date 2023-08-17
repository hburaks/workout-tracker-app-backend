package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public class ExerciseResponseDTO extends BaseEntity {
    String name;
    String description;
    String videoUrl;
    String imageUrl;
    BodyPartTypeEnum bodyPartType;
    List<WorkoutExerciseResponseDTO> workoutExerciseResponseDTOList;
    WorkoutExerciseResponseDTO maxVolumeWorkoutExerciseResponseDTO;
    SetResponseDTO maxWeightSetResponseDTO;
}
