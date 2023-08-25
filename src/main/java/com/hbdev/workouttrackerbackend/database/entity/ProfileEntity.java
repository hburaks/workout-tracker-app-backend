package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class ProfileEntity extends BaseEntity {
    @OneToMany(mappedBy = "profile", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<WorkoutEntity> workoutList;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<WorkoutTemplateEntity> workoutTemplateList;

}
