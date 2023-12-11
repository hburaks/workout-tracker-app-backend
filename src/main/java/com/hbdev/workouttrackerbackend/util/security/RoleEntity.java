package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table
public class RoleEntity extends BaseEntity {

    @Column(unique = true)
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity() {
    }

}