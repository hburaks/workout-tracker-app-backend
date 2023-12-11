package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultExerciseResponseDTO extends BaseResponseDTO {

    private String name;

    private String description;

    private String videoUrl;

    private String imageUrl;

    private BodyPartTypeEnum bodyPartType;

}
