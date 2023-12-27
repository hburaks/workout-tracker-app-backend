package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.model.responseDTO.checked.DefaultExerciseInCustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.SetInCustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutInCustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseResponseDTO extends BaseResponseDTO {

    private String name;

    private int volume;

    private String note;

    private int restTime;

    private List<SetInCustomExerciseResponseDTO> Sets;

    private DefaultExerciseInCustomExerciseResponseDTO defaultExercise;

    private WorkoutInCustomExerciseResponseDTO workout;

}
