package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseDTO;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public class ExerciseResponseDTO extends BaseDTO {
    private String name;
    private String description;
    private String videoUrl;
    private String imageUrl;
    private BodyPartTypeEnum bodyPartType;
    private List<WorkoutExerciseResponseDTO> workoutExerciseResponseDTOList;
    private WorkoutExerciseResponseDTO maxVolumeWorkoutExerciseResponseDTO;
    private SetResponseDTO maxWeightSetResponseDTO;
}
