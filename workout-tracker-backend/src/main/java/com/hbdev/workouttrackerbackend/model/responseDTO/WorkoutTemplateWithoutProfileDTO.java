package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;

import java.util.List;

public class WorkoutTemplateWithoutProfileDTO extends BaseResponseDTO {
    private String name;
    private List<WorkoutExerciseResponseDTO> workoutExerciseList;

}
