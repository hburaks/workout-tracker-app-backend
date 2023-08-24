package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutWithoutProfileResponseDTO extends BaseResponseDTO {
    private String name;
    private String notes;
    private int duration;
    private double totalWeight;
    private List<WorkoutExerciseResponseDTO> workoutExercise;
}
