package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutWithoutProfileAndWorkoutExerciseResponseDTO extends BaseResponseDTO {
    private String notes;
    private int duration;
    private double totalWeight;
}
