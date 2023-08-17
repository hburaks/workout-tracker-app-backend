package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.util.BaseDTO;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;
public class WorkoutTemplateRequestDTO extends BaseDTO {
    private String name;
    private List<WorkoutExerciseEntity> workoutExerciseList;

    private ProfileEntity profileEntity;
}
