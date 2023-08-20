package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutResponseDTO extends BaseResponseDTO {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String notes;
    private int duration;
    private double totalWeight;

    private List<WorkoutExerciseResponseDTO> workoutExercise;
    private ProfileResponseDTO profile;

}
