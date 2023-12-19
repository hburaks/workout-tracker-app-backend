package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveWorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkoutInProfileResponseDTO extends BaseResponseDTO {

    private int duration;

    private int volume;

    private Date date;

    private List<CustomExerciseInWorkoutResponseDTO> customExerciseList;

    private PrimitiveWorkoutTemplateResponseDTO workoutTemplate;

}
