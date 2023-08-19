package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutRequestDTO extends BaseRequestDTO {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String notes;
    private int duration;
    private double totalWeight;

    private List<WorkoutExerciseRequestDTO> workoutExerciseRequestDTOList;
    private ProfileRequestDTO profileRequestDTO;
}
