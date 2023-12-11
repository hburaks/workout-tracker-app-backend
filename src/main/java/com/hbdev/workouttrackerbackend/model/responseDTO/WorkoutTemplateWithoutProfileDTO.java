package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutTemplateWithoutProfileDTO extends BaseResponseDTO {
    private String name;
    private List<WorkoutExerciseWithoutTemplateResponseDTO> workoutExerciseList;
}
