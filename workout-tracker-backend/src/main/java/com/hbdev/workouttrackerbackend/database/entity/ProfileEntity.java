package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ProfileEntity extends BaseEntity {
    String firstName;
    String lastName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profileEntity", cascade = CascadeType.ALL)
    List<WorkoutEntity> workoutEntityList;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profileEntity", cascade = CascadeType.ALL)
    List<WorkoutTemplateEntity> workoutTemplateEntityList;

}
