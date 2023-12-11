package com.hbdev.workouttrackerbackend.database.entity;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class AppEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
    private List<DefaultExerciseEntity> defaultExerciseList;

    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
    private List<UserEntity> userList;

}
