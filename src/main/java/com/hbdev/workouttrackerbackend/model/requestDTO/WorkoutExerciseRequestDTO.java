package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;

import java.util.List;

public class WorkoutExerciseRequestDTO extends BaseRequestDTO {
    private String notes;
    private int setOrder;
    private int restTime;
    private ExerciseEntity exerciseEntity;

    private WorkoutTemplateEntity workoutTemplateEntity;

    private WorkoutEntity workoutEntity;

    private List<SetEntity> setEntities;

}
