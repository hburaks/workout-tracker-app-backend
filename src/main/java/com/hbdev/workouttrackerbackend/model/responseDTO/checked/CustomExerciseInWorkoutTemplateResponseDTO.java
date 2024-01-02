package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseInWorkoutTemplateResponseDTO extends BaseResponseDTO {

    private String name;

    private Integer volume;

    private String note;

    private Integer restTime;

    private List<SetInCustomExerciseResponseDTO> Sets;

    private DefaultExerciseInCustomExerciseResponseDTO defaultExercise;

}
