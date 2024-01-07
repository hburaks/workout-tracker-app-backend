package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTOWithDbName;
import com.hbdev.workouttrackerbackend.model.responseDTO.CustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CustomExerciseMapper extends BaseMapper<CustomExerciseEntity, CustomExerciseResponseDTO, CustomExerciseRequestDTOWithDbName> {

    CustomExerciseMapper INSTANCE = Mappers.getMapper(CustomExerciseMapper.class);
}
