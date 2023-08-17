package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
public class WorkoutTemplateResponseDTO extends BaseEntity {
    String name;
    List<WorkoutExerciseResponseDTO> workoutExerciseList;
}
