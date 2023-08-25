package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import lombok.Data;

import java.util.List;
@Data
public class ProfileWithoutWorkoutTemplateDTO extends BaseResponseDTO {
    private List<WorkoutResponseDTO> workoutList;
}
