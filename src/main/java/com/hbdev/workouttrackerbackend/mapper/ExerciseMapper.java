package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseMapper extends BaseMapper<ExercisePersonalRecordEntity, ExerciseResponseDTO, ExerciseRequestDTO> {

    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);


}

 