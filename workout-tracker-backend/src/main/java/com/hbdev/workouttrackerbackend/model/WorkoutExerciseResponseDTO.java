package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public class WorkoutExerciseResponseDTO extends BaseEntity {
    List<SetResponseDTO> setEntities;
    String notes;
    int order;
    int restTime;
    ExerciseResponseDTO exerciseResponseDTO;

}
