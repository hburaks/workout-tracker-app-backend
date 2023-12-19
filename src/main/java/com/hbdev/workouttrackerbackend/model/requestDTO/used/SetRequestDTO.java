package com.hbdev.workouttrackerbackend.model.requestDTO.used;

import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetRequestDTO extends BaseRequestDTO {

    private double weight;

    private int reps;

    private SetTypeEnum setTypeEnum;

    private WeightUnitTypeEnum weightUnitTypeEnum;

}
