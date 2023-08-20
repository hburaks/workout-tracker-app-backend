package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutTemplateResponseDTO extends BaseResponseDTO {
    private String name;
    private List<WorkoutExerciseResponseDTO> workoutExerciseList;

    private ProfileWithoutWorkoutTemplateDTO profile;
}
