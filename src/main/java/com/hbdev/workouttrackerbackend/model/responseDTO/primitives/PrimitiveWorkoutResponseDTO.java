package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrimitiveWorkoutResponseDTO extends BaseResponseDTO {

    private int duration;

    private int volume;

    private Date date;

}
