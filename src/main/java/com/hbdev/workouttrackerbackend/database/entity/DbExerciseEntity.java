package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.EquipmentTypeDbEnum;
import com.hbdev.workouttrackerbackend.model.enums.ForceDbEnum;
import com.hbdev.workouttrackerbackend.model.enums.LevelDbEnum;
import com.hbdev.workouttrackerbackend.model.enums.MuscleGroupDbEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "db_exercise_entity")
@Entity
@Getter
@Setter
public class DbExerciseEntity {

    private String name;

    private String force;

    private String level;

    private String mechanic;

    private String equipment;

    private String primaryMuscles;

    private String secondaryMuscles;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    private String category;

    @Column(columnDefinition = "TEXT")
    private String images;

    @Id
    private String id;

}
