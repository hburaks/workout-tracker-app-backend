package com.hbdev.workouttrackerbackend.model.enums;


import lombok.Getter;

@Getter
public enum ForceDbEnum {

    PULL("pull"),

    PUSH("push"),

    STATIC("static");

    private final String forceName;

    ForceDbEnum(String forceName) {
        this.forceName = forceName;
    }

    public String getForceName() {
        return forceName;
    }

}


