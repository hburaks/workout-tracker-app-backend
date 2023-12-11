package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRequestDTO extends BaseRequestDTO {
    private String notes;
    private int duration;
    private double totalWeight;

    private Long profileId;
}
