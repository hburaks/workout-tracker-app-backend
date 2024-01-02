package com.hbdev.workouttrackerbackend.model.responseDTO.primitives;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrimitiveWorkoutResponseDTO extends BaseResponseDTO {

    private Integer duration;

    private Integer volume;

    private Date date;

}
