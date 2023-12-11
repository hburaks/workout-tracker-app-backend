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
public class WorkoutTemplateEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "workoutTemplate")
    private List<DefaultExerciseEntity> defaultExerciseList;

    @OneToMany(mappedBy = "workoutTemplate", cascade = CascadeType.ALL)
    private List<WorkoutEntity> workout;

}
