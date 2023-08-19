package com.hbdev.workouttrackerbackend.mapper;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.model.WorkoutResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.WorkoutRequestDTO;
import com.hbdev.workouttrackerbackend.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkoutMapperI extends IBaseMapper<WorkoutEntity, WorkoutResponseDTO, WorkoutRequestDTO> {
    WorkoutMapperI INSTANCE = Mappers.getMapper(WorkoutMapperI.class);
}
