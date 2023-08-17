package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;
public class WorkoutTemplateRequestDTO extends BaseEntity {
    String name;
    List<WorkoutExerciseRequestDTO> workoutExerciseList;
}
