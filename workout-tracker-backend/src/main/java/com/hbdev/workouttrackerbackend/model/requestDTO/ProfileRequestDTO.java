package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProfileRequestDTO extends BaseRequestDTO {
    private String firstName;
    private String lastName;
   /* private List<WorkoutRequestDTO> workoutList;
    private List<WorkoutTemplateRequestDTO> workoutTemplateList;*/

}
