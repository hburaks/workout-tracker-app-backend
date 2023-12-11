package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserJustResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileWithoutWorkoutTemplateDTO extends BaseResponseDTO {
    private List<WorkoutWithoutProfileAndWorkoutExerciseResponseDTO> workoutList;
    private UserJustResponseDTO user;
    private List<ExerciseResponseDTO> exerciseList;

}
