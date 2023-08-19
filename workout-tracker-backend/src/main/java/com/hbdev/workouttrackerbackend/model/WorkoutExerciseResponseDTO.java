package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutExerciseResponseDTO extends BaseResponseDTO {
    private String notes;
    private int setOrder;
    private int restTime;


    private ExerciseResponseDTO exerciseResponseDTO;

    private WorkoutTemplateResponseDTO workoutTemplateResponseDTO;

    private WorkoutResponseDTO workoutResponseDTO;

    private List<SetResponseDTO> setResponseDTOList;

}
