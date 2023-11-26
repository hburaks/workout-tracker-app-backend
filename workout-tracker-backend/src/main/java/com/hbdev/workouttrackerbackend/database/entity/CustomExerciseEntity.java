package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class CustomExerciseEntity extends BaseEntity {
    @OneToOne
    private ProfileEntity profile;
    private String name;
    @Enumerated(EnumType.STRING)
    private BodyPartTypeEnum bodyPartType;
}
