package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutExerciseForTemplateResponseDTO extends BaseResponseDTO {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseResponseDTO exercise;
    private WorkoutTemplateResponseDTO workoutTemplate;
    private WorkoutResponseDTO workout;
    private List<SetResponseDTO> setList;
}
