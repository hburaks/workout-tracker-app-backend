package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.PrimitiveUserResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileResponseDTO extends BaseResponseDTO {

    private PrimitiveUserResponseDTO user;

    private List<WorkoutResponseDTO> workoutList;

    private List<WorkoutTemplateResponseDTO> workoutTemplateList;

    private List<CustomExerciseResponseDTO> customExerciseList;

}
