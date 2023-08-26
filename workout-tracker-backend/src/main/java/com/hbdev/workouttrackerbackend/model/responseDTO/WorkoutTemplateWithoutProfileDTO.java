package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;
@Data
public class WorkoutTemplateWithoutProfileDTO extends BaseResponseDTO {
    private String name;
    private List<WorkoutExerciseWithoutTemplateResponseDTO> workoutExerciseList;
}
