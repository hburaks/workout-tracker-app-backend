package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.DefaultExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.DefaultExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.DefaultExerciseInListResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DefaultExerciseMapper extends BaseMapper<DefaultExerciseEntity, DefaultExerciseResponseDTO, DefaultExerciseRequestDTO> {

    DefaultExerciseMapper INSTANCE = Mappers.getMapper(DefaultExerciseMapper.class);

    List<DefaultExerciseInListResponseDTO> listToResponseList(List<DefaultExerciseEntity> defaultExerciseEntityList);


}

 