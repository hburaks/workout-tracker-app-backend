package com.hbdev.workouttrackerbackend.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "db_exercises")
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
