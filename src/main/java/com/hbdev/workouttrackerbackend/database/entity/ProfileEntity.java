package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class ProfileEntity extends BaseEntity {

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<WorkoutEntity> workoutList;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutTemplateEntity> workoutTemplateList;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomExerciseEntity> customExerciseList;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<DefaultExerciseEntity> defaultExerciseList;

}
