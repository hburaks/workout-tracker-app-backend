package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutResponseDTO extends BaseResponseDTO {
    private String notes;
    private int duration;
    private double totalWeight;
    private List<WorkoutExerciseResponseDTO> workoutExerciseList;
    private ProfileResponseDTO profile;
}
