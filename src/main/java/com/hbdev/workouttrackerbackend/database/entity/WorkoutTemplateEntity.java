package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "workout_templates")
@Entity
@Getter
@Setter
public class WorkoutTemplateEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "workoutTemplate", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CustomExerciseEntity> customExerciseList;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

}
