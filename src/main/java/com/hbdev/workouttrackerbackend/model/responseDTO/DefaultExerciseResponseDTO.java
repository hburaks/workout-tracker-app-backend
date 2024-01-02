package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefaultExerciseResponseDTO extends BaseResponseDTO {

    private String note;

    private Integer rm1;

    private List<CustomExerciseResponseDTO> volumePrExercise;

    private DbExerciseResponseDTO dbExercise;

}
