package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class UserEntity extends BaseEntity {
    @Column(unique = true)
    String username;
    @Column
    String password;
    @Column(unique = true)
    String email;
    @Column
    String firstName;
    @Column
    String lastName;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    List<WorkoutEntity> workoutEntityList;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    List<WorkoutTemplateEntity> workoutTemplateEntityList;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    List<ExerciseEntity> exerciseEntityList;

}
