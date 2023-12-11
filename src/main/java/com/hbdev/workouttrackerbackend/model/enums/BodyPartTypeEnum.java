package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum BodyPartTypeEnum {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    LEGS("Legs"),
    CORE("Core"),
    CARDIO("Cardio"),
    OTHER("Other");

    private final String value;

    BodyPartTypeEnum(String value) {
        this.value = value;
    }

}

