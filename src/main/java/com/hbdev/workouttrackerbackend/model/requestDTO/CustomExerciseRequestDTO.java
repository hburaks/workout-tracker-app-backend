package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomExerciseRequestDTO extends BaseRequestDTO {

    /*
        private Integer volume;
    */
    private String name;

    private String note;

    private boolean isNoteForGeneral;

    private Integer restTime;

    private List<SetRequestDTO> Sets;

}
