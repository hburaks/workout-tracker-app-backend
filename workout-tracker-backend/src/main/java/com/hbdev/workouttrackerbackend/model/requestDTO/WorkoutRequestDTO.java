package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class WorkoutRequestDTO extends BaseEntity {
    String name;
    String imageUrl;
    String videoUrl;
    String notes;
    int duration;
    List<WorkoutExerciseRequestDTO> workoutExerciseList;
    double totalWeight;

}
