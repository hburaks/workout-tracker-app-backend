package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetWithoutWorkoutExerciseResponseDTO extends BaseResponseDTO {
    private double weight;
    private int reps;
    private int setOrder;
}
