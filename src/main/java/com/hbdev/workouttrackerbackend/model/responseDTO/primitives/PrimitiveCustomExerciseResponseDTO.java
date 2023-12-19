package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimitiveCustomExerciseResponseDTO extends BaseResponseDTO {

    private String name;

    private int volume;

    private String note;

    private int restTime;

}
