package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomExerciseRequestDTO extends BaseRequestDTO {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseRequestDTO exercise;

    private WorkoutTemplateRequestDTO workoutTemplate;

    private WorkoutRequestDTO workout;

    private List<SetRequestDTO> setList;

}
