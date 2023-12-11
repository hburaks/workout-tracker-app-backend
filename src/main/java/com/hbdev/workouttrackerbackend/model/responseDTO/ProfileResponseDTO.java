package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserJustResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileResponseDTO extends BaseResponseDTO {
    private List<WorkoutWithoutProfileResponseDTO> workoutList;
    private List<WorkoutTemplateWithoutProfileDTO> workoutTemplateList;
    private List<ExerciseResponseDTO> exerciseList;
    private UserJustResponseDTO user;
}
