package com.hbdev.workouttrackerbackend.model.responseDTO;

import com.hbdev.workouttrackerbackend.database.entity.AppEntity;
import com.hbdev.workouttrackerbackend.model.enums.BodyPartTypeEnum;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class DefaultExerciseResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
    private String videoUrl;
    private String imageUrl;
    private BodyPartTypeEnum bodyPartType;
    private AppEntity app;
}
