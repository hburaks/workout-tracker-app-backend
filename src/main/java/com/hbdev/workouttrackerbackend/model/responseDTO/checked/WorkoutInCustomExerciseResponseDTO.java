package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveWorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkoutInCustomExerciseResponseDTO extends BaseResponseDTO {

    private Integer duration;

    private Integer volume;

    private Date date;

    private PrimitiveWorkoutTemplateResponseDTO workoutTemplate;

}
