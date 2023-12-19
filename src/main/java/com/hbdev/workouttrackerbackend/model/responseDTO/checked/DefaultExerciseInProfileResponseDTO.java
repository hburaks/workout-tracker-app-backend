package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.CustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefaultExerciseInProfileResponseDTO extends BaseResponseDTO {

    private String note;

    private int rm1;

    private DbExerciseResponseDTO dbExercise;

}
