package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class WorkoutExerciseRequestDTO extends BaseEntity {
    List<SetRequestDTO> setEntities;
    String notes;
    int order;
    int restTime;
    ExerciseRequestDTO exerciseRequestDTO;

}
