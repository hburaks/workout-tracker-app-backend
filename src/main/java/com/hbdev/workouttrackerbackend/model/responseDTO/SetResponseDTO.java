package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.PrimitiveCustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetResponseDTO extends BaseResponseDTO {

    private double weight;

    private int reps;

    private SetTypeEnum setTypeEnum;

    private WeightUnitTypeEnum weightUnitTypeEnum;

    private PrimitiveCustomExerciseResponseDTO customExercise;

}
