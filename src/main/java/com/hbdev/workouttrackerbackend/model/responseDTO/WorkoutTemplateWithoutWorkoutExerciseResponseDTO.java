package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

@Data
public class WorkoutTemplateWithoutWorkoutExerciseResponseDTO extends BaseResponseDTO {
    private String name;
    private ProfileWithoutWorkoutTemplateDTO profile;
}
