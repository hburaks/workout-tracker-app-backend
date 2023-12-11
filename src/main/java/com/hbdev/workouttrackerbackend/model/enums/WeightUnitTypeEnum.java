package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum WeightUnitTypeEnum {

    LB("Lb"), KG("Kg");

    private final String value;

    WeightUnitTypeEnum(String value) {
        this.value = value;
    }

}

