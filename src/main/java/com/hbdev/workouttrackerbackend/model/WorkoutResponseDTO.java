package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;

import java.util.List;

public class WorkoutResponseDTO extends BaseResponseDTO {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String notes;
    private int duration;
    private List<WorkoutExerciseEntity> workoutExerciseList;
    private double totalWeight;

    private ProfileEntity profileEntity;

}
