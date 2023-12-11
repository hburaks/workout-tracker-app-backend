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

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<WorkoutTemplateEntity> workoutTemplateList;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<CustomExerciseEntity> customExerciseList;

}
