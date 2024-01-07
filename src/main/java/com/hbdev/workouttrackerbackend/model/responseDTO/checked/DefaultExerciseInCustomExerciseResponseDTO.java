package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultExerciseInCustomExerciseResponseDTO extends BaseResponseDTO {

    private String name;

    private String note;

    private Integer rm1;

    private DbExerciseResponseDTO dbExercise;

}
