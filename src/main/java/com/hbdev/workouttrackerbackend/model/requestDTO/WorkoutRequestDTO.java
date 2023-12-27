package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutRequestDTO extends BaseRequestDTO {

    private boolean updateTemplate;

    private List<CustomExerciseRequestDTO> customExerciseList;

}
