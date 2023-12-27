package com.hbdev.workouttrackerbackend.model.responseDTO.checked;

import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetInCustomExerciseResponseDTO extends BaseResponseDTO {

    private double weight;

    private int reps;

    private SetTypeEnum setTypeEnum;

    private WeightUnitTypeEnum weightUnitTypeEnum;

}
