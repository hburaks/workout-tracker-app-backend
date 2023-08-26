package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutExerciseWithoutWorkoutAndTemplateResponseDTO extends BaseResponseDTO {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseWithoutWorkoutExerciseResponseDTO exercise;
    private List<SetWithoutWorkoutExerciseResponseDTO> setList;
}
