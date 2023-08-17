package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class WorkoutRequestDTO extends BaseEntity {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String notes;
    private int duration;
    private List<WorkoutExerciseEntity> workoutExerciseList;
    private double totalWeight;

    private ProfileEntity profileEntity;
}
