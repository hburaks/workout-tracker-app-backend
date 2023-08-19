package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutExerciseRequestDTO extends BaseRequestDTO {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseRequestDTO exerciseRequestDTO;

    private WorkoutTemplateRequestDTO workoutTemplateRequestDTO;

    private WorkoutRequestDTO workoutRequestDTO;

    private List<SetRequestDTO> setRequestDTOList;

}
