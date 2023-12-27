package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveSetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseInWorkoutResponseDTO extends BaseResponseDTO {

    private String name;

    private int volume;

    private String note;

    private int restTime;

    private List<PrimitiveSetResponseDTO> sets;

    private DefaultExerciseInCustomExerciseResponseDTO defaultExercise;

}