package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "default_exercises")
@Entity
@Getter
@Setter
public class DefaultExerciseEntity extends BaseEntity {

    private String note;

    private Integer rm1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "db_exercise_id")
    private DbExerciseEntity dbExercise;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}