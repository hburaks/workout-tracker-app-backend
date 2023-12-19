package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.model.enums.SetTypeEnum;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sets")
@Getter
@Setter
public class SetEntity extends BaseEntity {

    private double weight;

    private int reps;

    private boolean isDone;

    @Enumerated(EnumType.STRING)
    private SetTypeEnum setTypeEnum;

    @Enumerated(EnumType.STRING)
    private WeightUnitTypeEnum weightUnitTypeEnum;

    @ManyToOne
    @JoinColumn(name = "custom_exercise_id")
    private CustomExerciseEntity customExercise;

}
