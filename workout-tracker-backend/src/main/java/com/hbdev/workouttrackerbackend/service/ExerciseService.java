package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.ExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExerciseService extends BaseService<ExerciseResponseDTO, ExerciseRequestDTO, ExerciseEntity, ExerciseMapper, ExerciseRepository, ExerciseSpecification> {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseSpecification exerciseSpecification;


    @Override
    protected ExerciseMapper getMapper() {
        return ExerciseMapper.INSTANCE;
    }

    @Override
    protected ExerciseRepository getRepository() {
        return exerciseRepository;
    }

    @Override
    protected ExerciseSpecification getSpecification() {
        return exerciseSpecification;
    }


}
