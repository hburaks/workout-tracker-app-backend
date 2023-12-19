package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimitiveDefaultExerciseResponseDTO extends BaseResponseDTO {

    private String note;

    private int rm1;

    private DbExerciseResponseDTO dbExercise;

}
