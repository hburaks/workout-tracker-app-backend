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
        private int volume;
    */
    private String name;

    private String note;

    private boolean isNoteForGeneral;

    private int restTime;

    private List<SetRequestDTO> Sets;

}
