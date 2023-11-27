package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.model.requestDTO.DefaultExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.SetRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SetMapper extends BaseMapper<SetEntity, SetResponseDTO, SetRequestDTO> {
    SetMapper INSTANCE = Mappers.getMapper(SetMapper.class);

    @Override
    @Mapping(source = "workoutExerciseId", target = "workoutExercise.id")
    SetEntity requestDtoToEntity(SetRequestDTO requestDTO);
}