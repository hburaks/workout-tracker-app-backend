package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserJustResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProfileResponseDTO extends BaseResponseDTO {
    private List<WorkoutWithoutProfileResponseDTO> workoutList;
    private List<WorkoutTemplateWithoutProfileDTO> workoutTemplateList;
    private List<ExerciseResponseDTO> exerciseList;
    private UserJustResponseDTO user;
}
