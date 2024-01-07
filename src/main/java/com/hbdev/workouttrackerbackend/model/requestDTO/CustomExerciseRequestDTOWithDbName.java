package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomExerciseRequestDTOWithDbName extends BaseRequestDTO {

    private String note;

    private boolean isNoteForGeneral;

    private Integer restTime;

    private List<SetRequestDTO> Sets;

    private UUID defaultExerciseUUID;

}
