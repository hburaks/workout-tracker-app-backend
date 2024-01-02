package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkoutInWorkoutTemplateResponseDTO extends BaseResponseDTO {

    private Integer duration;

    private Double volume;

    private Date date;

    private List<CustomExerciseInWorkoutTemplateResponseDTO> customExerciseList;

}
