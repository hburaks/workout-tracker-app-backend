package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class WorkoutTemplateRequestDTO extends BaseRequestDTO {
    private String name;
    private Long profileId;
}
