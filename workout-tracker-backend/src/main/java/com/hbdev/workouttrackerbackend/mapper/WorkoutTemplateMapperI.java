package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.model.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkoutTemplateMapperI extends IBaseMapper<WorkoutTemplateEntity, WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO> {
    WorkoutTemplateMapperI INSTANCE = Mappers.getMapper(WorkoutTemplateMapperI.class);


}

