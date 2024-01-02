package com.hbdev.workouttrackerbackend.model.requestDTO.used;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomExerciseRequestForTemplateDTO extends BaseRequestDTO {

    private String note;

    private Integer restTime;

    private List<SetRequestDTO> Sets;

    private UUID defaultExerciseUuid;

}
