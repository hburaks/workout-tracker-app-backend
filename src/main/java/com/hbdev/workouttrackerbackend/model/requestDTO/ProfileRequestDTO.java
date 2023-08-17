package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class ProfileRequestDTO extends BaseEntity {
    private String firstName;
    private String lastName;
    private List<WorkoutEntity> workoutEntityList;
    private List<WorkoutTemplateEntity> workoutTemplateEntityList;

}
