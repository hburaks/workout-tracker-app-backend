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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WorkoutEntity> workoutEntityList;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WorkoutTemplateEntity> workoutTemplateEntityList;

}
