package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum EquipmentTypeDbEnum {

    NONE("none"),

    BARBELL("barbell"),

    DUMBBELL("dumbbell"),

    OTHER("other"),

    BODY_ONLY("body only"),

    CABLE("cable"),

    MACHINE("machine"),

    KETTLEBELLS("kettlebells"),

    BANDS("bands"),

    MEDICINE_BALL("medicine ball"),

    EXERCISE_BALL("exercise ball"),

    FOAM_ROLL("foam roll"),

    E_Z_CURL_BAR("e-z curl bar");

    private final String equipmentName;

    EquipmentTypeDbEnum(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }
}


