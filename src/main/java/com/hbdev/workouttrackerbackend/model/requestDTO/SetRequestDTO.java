package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class SetRequestDTO extends BaseRequestDTO {

    private double weight;
    private int reps;
    private int setOrder;

    private Long workoutExerciseId;
}
