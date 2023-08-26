package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkoutMapper extends BaseMapper<WorkoutEntity, WorkoutResponseDTO, WorkoutRequestDTO> {
    WorkoutMapper INSTANCE = Mappers.getMapper(WorkoutMapper.class);

    @Override
    @Mapping(source = "profileId", target = "profile.id")
    WorkoutEntity requestDtoToEntity(WorkoutRequestDTO requestDTO);
}