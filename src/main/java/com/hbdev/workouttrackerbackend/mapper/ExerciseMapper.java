package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseMapper extends GenericMapper<ExerciseEntity,ExerciseResponseDTO,ExerciseRequestDTO> {
}

 