package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class DefaultExerciseEntity extends BaseEntity {
    private String name;
    private String description;
    private String videoUrl;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private BodyPartTypeEnum bodyPartType;
}