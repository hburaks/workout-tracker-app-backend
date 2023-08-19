package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;

import java.util.List;

public class ProfileResponseDTO extends BaseResponseDTO {
    private String firstName;
    private String lastName;
    private List<WorkoutEntity> workoutEntityList;
    private List<WorkoutTemplateEntity> workoutTemplateEntityList;

}
