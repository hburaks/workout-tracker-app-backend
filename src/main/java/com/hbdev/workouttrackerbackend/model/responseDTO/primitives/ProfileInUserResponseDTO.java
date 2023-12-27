package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.model.responseDTO.checked.CustomExerciseInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.DefaultExerciseInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileInUserResponseDTO extends BaseResponseDTO {

    private List<WorkoutInProfileResponseDTO> workoutList;

    private List<WorkoutTemplateInProfileResponseDTO> workoutTemplateList;

    private List<DefaultExerciseInProfileResponseDTO> defaultExerciseList;

    private List<CustomExerciseInProfileResponseDTO> customExerciseList;

}
