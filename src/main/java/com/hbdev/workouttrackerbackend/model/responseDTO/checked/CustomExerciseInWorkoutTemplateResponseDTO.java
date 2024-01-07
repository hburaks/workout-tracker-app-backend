package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveSetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseInWorkoutTemplateResponseDTO extends BaseResponseDTO {

    private Integer volume;

    private String note;

    private Integer restTime;

    private List<PrimitiveSetResponseDTO> Sets;

    private DefaultExerciseInCustomExerciseResponseDTO defaultExercise;

}
