package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProfileResponseDTO extends BaseResponseDTO {
    private String firstName;
    private String lastName;
    private List<WorkoutResponseDTO> workoutResponseDTOList;
    private List<WorkoutTemplateResponseDTO> workoutTemplateResponseDTOList;

}
