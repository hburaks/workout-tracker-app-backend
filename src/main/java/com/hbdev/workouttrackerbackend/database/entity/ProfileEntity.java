package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class ProfileEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<WorkoutEntity> workoutList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private List<WorkoutTemplateEntity> workoutTemplateList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private List<CustomExerciseEntity> customExerciseList;

}
