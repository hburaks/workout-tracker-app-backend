package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutTemplateResponseDTO extends BaseResponseDTO {
    private String name;
    private List<WorkoutExerciseResponseDTO> workoutExerciseResponseDTOList;

    private ProfileResponseDTO profileResponseDTO;
}
