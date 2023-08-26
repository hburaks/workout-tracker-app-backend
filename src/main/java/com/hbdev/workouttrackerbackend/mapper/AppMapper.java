package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.AppEntity;
import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.AppRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.AppResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppMapper extends BaseMapper<AppEntity, AppResponseDTO, AppRequestDTO> {

    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);
}

 