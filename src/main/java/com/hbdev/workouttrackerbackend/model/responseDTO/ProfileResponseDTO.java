package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProfileResponseDTO extends BaseResponseDTO {
    private List<WorkoutWithoutProfileResponseDTO> workoutList;
    private List<WorkoutTemplateWithoutProfileDTO> workoutTemplateList;
}
