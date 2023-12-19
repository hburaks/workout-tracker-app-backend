package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.DbExerciseEntity;
import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface DbExerciseMapper {


    DbExerciseResponseDTO entityToResponseDto(DbExerciseEntity entity);

    List<DbExerciseResponseDTO> entityListToResponseDtoList(List<DbExerciseEntity> entityList);

}
