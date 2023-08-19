package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutExerciseEntity;
import com.hbdev.workouttrackerbackend.model.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface WorkoutExerciseMapperI extends IBaseMapper<WorkoutExerciseEntity, WorkoutExerciseResponseDTO, WorkoutExerciseRequestDTO> {

    WorkoutExerciseMapperI INSTANCE = Mappers.getMapper(WorkoutExerciseMapperI.class);
}
