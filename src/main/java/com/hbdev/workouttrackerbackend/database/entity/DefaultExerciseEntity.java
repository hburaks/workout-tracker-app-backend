package com.hbdev.workouttrackerbackend.database.entity;

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

    private String note;

    private int rm1;

    @OneToMany(mappedBy = "defaultExercise", cascade = CascadeType.ALL)
    private List<CustomExerciseEntity> volumePrExercise;

    @OneToOne(cascade = CascadeType.ALL)
    private DbExerciseEntity dbExercise;

}