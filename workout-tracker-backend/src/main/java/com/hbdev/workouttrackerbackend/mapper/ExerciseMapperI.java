package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseMapperI extends IBaseMapper<ExerciseEntity, ExerciseResponseDTO, ExerciseRequestDTO> {

    ExerciseMapperI INSTANCE = Mappers.getMapper(ExerciseMapperI.class);


}

 