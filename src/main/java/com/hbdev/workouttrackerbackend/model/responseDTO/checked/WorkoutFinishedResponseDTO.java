package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveWorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkoutFinishedResponseDTO extends BaseResponseDTO {

    private Integer durationInSecond;

    private Double volume;

    private Date startDate;

    private Date endDate;

    private List<CustomExerciseInWorkoutResponseDTO> customExerciseList;

    private PrimitiveWorkoutTemplateResponseDTO workoutTemplate;

}
