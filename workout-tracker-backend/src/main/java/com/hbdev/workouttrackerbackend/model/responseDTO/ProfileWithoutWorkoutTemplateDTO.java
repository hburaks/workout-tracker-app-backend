package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserJustResponseDTO;
import lombok.Data;

import java.util.List;
@Data
public class ProfileWithoutWorkoutTemplateDTO extends BaseResponseDTO {
    private List<WorkoutWithoutProfileAndWorkoutExerciseResponseDTO> workoutList;
    private UserJustResponseDTO user;
    private List<ExerciseResponseDTO> exerciseList;

}
