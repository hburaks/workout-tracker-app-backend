package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
    private String videoUrl;
    private String imageUrl;

    private BodyPartTypeEnum bodyPartType;
    private WorkoutExerciseResponseDTO maxVolumeWorkoutExercise;
    private SetResponseDTO maxWeightSet;
}
