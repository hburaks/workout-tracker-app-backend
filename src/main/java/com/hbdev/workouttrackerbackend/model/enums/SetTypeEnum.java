package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum SetTypeEnum {

    WARMUP("Warm Up"), DROPSET("Drop Set"), REGULAR("Regular");

    private final String value;

    SetTypeEnum(String value) {
        this.value = value;
    }

}

