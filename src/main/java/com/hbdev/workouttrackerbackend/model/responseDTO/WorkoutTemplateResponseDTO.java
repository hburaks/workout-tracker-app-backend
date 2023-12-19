package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveDefaultExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutTemplateResponseDTO extends BaseResponseDTO {

    private String name;

    private List<PrimitiveDefaultExerciseResponseDTO> defaultExerciseList;

    private List<WorkoutResponseDTO> workout;

}
