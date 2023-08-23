package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;
@Data
public class ProfileWithoutWorkoutTemplateDTO extends BaseResponseDTO {
    private String firstName;
    private String lastName;
    private List<WorkoutResponseDTO> workoutList;
}
