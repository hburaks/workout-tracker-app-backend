package com.hbdev.workouttrackerbackend.model.enums;

public enum MuscleGroupDbEnum {
    QUADRICEPS("quadriceps"),
    SHOULDERS("shoulders"),
    ABDOMINALS("abdominals"),
    CHEST("chest"),
    HAMSTRINGS("hamstrings"),
    TRICEPS("triceps"),
    BICEPS("biceps"),
    LATS("lats"),
    MIDDLE_BACK("middle back"),
    CALVES("calves"),
    LOWER_BACK("lower back"),
    FOREARMS("forearms"),
    GLUTES("glutes"),
    TRAPS("traps"),
    ADDUCTORS("adductors"),
    ABDUCTORS("abductors"),
    NECK("neck");

    private final String muscleName;

    MuscleGroupDbEnum(String muscleName) {
        this.muscleName = muscleName;
    }

    public String getMuscleName() {
        return muscleName;
    }
}
