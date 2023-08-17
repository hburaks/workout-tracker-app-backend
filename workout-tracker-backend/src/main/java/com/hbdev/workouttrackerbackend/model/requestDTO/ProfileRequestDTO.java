package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseEntity;

import java.util.List;

public class ProfileRequestDTO extends BaseEntity {
    String firstName;
    String lastName;
    List<WorkoutRequestDTO> workoutRequestDTOList;
    List<WorkoutTemplateRequestDTO> workoutTemplateRequestDTOList;

}
