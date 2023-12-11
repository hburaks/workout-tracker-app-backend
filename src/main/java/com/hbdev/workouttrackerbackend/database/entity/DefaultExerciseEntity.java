package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class DefaultExerciseEntity extends BaseEntity {

    private String name;

    private String description;

    private String imageUrl;

    private String note;

    private int rm1;

    @Enumerated(EnumType.STRING)
    private BodyPartTypeEnum bodyPartType;

    @OneToMany(mappedBy = "defaultExercise", cascade = CascadeType.ALL)
    private List<CustomExerciseEntity> volumePrExercise;

}