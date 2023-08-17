package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
public class WorkoutTemplateResponseDTO extends BaseEntity {
    private String name;
    private List<WorkoutExerciseEntity> workoutExerciseList;

    private ProfileEntity profileEntity;
}
