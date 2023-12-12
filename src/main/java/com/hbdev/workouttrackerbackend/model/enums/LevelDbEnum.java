package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum LevelDbEnum {

    BEGINNER("beginner"),

    INTERMEDIATE("intermediate"),

    EXPERT("expert");

    private final String levelName;

    LevelDbEnum(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }
}


