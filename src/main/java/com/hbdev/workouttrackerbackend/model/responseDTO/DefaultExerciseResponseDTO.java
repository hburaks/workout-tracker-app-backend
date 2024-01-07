package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultExerciseResponseDTO extends BaseResponseDTO {

    private String name;

    private String note;

    private Integer rm1;

    private boolean hasDbExercise;

    private DbExerciseResponseDTO dbExercise;

}
