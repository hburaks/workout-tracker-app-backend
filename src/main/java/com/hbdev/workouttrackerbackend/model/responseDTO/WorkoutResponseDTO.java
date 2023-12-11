package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutResponseDTO extends BaseResponseDTO {
    private String notes;
    private int duration;
    private double totalWeight;
    private List<WorkoutExerciseResponseDTO> workoutExerciseList;
    private ProfileResponseDTO profile;
}
