package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutTemplateEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.WorkoutTemplateRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutTemplateResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.WorkoutTemplateInProfileResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkoutTemplateMapper extends BaseMapper<WorkoutTemplateEntity, WorkoutTemplateResponseDTO, WorkoutTemplateRequestDTO> {
    WorkoutTemplateMapper INSTANCE = Mappers.getMapper(WorkoutTemplateMapper.class);

    List<WorkoutTemplateInProfileResponseDTO> entityListToResponseDtoListInProfile(List<WorkoutTemplateEntity> entityList);


}

