package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutTemplateWithoutWorkoutExerciseResponseDTO extends BaseResponseDTO {
    private String name;
    private ProfileWithoutWorkoutTemplateDTO profile;
}
