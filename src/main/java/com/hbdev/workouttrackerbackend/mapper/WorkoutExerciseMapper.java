package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface WorkoutExerciseMapper extends BaseMapper<PrimitiveExerciseEntity, WorkoutExerciseResponseDTO, WorkoutExerciseRequestDTO> {

    WorkoutExerciseMapper INSTANCE = Mappers.getMapper(WorkoutExerciseMapper.class);
}
