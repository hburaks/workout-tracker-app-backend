package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.BaseDTO;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ProfileResponseDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private List<WorkoutEntity> workoutEntityList;
    private List<WorkoutTemplateEntity> workoutTemplateEntityList;

}
