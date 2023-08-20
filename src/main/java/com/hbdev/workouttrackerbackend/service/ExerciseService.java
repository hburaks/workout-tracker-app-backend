package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ExerciseService extends BaseService<ExerciseResponseDTO, ExerciseRequestDTO, ExerciseEntity, ExerciseMapper, ExerciseRepository> {
    private final ExerciseRepository exerciseRepository;


    @Override
    protected ExerciseMapper getBaseMapper() {
        return ExerciseMapper.INSTANCE;
    }

    @Override
    protected ExerciseRepository getBaseRepository() {
        return exerciseRepository;
    }


}
