package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseInWorkoutTemplateResponseDTO extends BaseResponseDTO {

    private String name;

    private int volume;

    private String note;

    private int restTime;

    private List<SetInCustomExerciseResponseDTO> Sets;

    private DefaultExerciseInCustomExerciseResponseDTO defaultExercise;

}
