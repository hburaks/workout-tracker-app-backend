package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SetMapper extends BaseMapper<SetEntity, SetResponseDTO, SetRequestDTO> {
    SetMapper INSTANCE = Mappers.getMapper(SetMapper.class);

    @Mapping(target = "isDone", constant = "false")
    List<SetEntity> requestListToEntityList(List<SetRequestDTO> requestDTOList);

   /* @Override
    @Mapping(source = "customExerciseId", target = "customExercise.id")
    SetEntity requestDtoToEntity(SetRequestDTO requestDTO);*/
}
