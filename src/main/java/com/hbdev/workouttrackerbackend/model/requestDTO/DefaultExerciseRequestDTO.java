package com.hbdev.workouttrackerbackend.model.requestDTO;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultExerciseRequestDTO extends BaseRequestDTO {

    private String name;

    private String description;

    private String imageUrl;

    private String note;

    private Integer rm1;

    private BodyPartTypeEnum bodyPartType;

}
