package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class ProfileEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<WorkoutEntity> workoutList;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<WorkoutTemplateEntity> workoutTemplateList;

}
