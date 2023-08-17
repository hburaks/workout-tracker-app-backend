package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class ExerciseRequestDTO extends BaseEntity {
    String name;
    String description;
    String videoUrl;
    String imageUrl;
    BodyPartTypeEnum bodyPartType;
    List<WorkoutExerciseRequestDTO> workoutExerciseRequestDTOList;
    WorkoutExerciseRequestDTO maxVolumeWorkoutExerciseRequestDTO;
    SetRequestDTO maxWeightSetRequestDTO;
}
