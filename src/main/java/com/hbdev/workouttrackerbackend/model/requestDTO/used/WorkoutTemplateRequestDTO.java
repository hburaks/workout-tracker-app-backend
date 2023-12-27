package com.hbdev.workouttrackerbackend.model.requestDTO.used;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutTemplateRequestDTO extends BaseRequestDTO {

    private String name;

    private List<CustomExerciseRequestForTemplateDTO> customExerciseRequestDTOList;

}
