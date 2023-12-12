package com.hbdev.workouttrackerbackend.model.responseDTOChecked;

import com.hbdev.workouttrackerbackend.model.enums.*;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
