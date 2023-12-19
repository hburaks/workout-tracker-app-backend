package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkoutTemplateMapper extends BaseMapper<WorkoutTemplateEntity, WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO> {
    WorkoutTemplateMapper INSTANCE = Mappers.getMapper(WorkoutTemplateMapper.class);

}

