package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public class WorkoutResponseDTO extends BaseEntity {
    String name;
    String imageUrl;
    String videoUrl;
    String notes;
    int duration;
    List<WorkoutExerciseResponseDTO> workoutExerciseList;
    double totalWeight;

}
