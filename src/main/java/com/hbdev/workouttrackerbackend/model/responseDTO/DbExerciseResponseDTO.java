package com.hbdev.workouttrackerbackend.model.responseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbExerciseResponseDTO {

    private String name;

    private String force;

    private String level;

    private String mechanic;

    private String equipment;

    private String primaryMuscles;

    private String secondaryMuscles;

    private String instructions;

    private String category;

    private String images;

    private String id;

}
