package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public class WorkoutExerciseResponseDTO extends BaseEntity {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseEntity exerciseEntity;

    private WorkoutTemplateEntity workoutTemplateEntity;

    private WorkoutEntity workoutEntity;

    private List<SetEntity> setEntities;

}
