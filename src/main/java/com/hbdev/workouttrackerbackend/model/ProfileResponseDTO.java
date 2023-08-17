package com.hbdev.workouttrackerbackend.model;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ProfileResponseDTO extends BaseEntity {
    String firstName;
    String lastName;
    List<WorkoutResponseDTO> workoutResponseDTOList;
    List<WorkoutTemplateResponseDTO> workoutTemplateResponseDTOList;

}
