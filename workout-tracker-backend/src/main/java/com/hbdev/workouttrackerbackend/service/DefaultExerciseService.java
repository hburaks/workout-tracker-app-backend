package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.DefaultExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.DefaultExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.DefaultExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.DefaultExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.DefaultExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DefaultExerciseService extends BaseService<DefaultExerciseResponseDTO, DefaultExerciseRequestDTO, DefaultExerciseEntity, DefaultExerciseMapper, DefaultExerciseRepository, DefaultExerciseSpecification> {
    private final DefaultExerciseRepository defaultExerciseRepository;
    private final DefaultExerciseSpecification defaultExerciseSpecification;


    @Override
    protected DefaultExerciseMapper getMapper() {
        return DefaultExerciseMapper.INSTANCE;
    }

    @Override
    protected DefaultExerciseRepository getRepository() {
        return defaultExerciseRepository;
    }

    @Override
    protected DefaultExerciseSpecification getSpecification() {
        return defaultExerciseSpecification;
    }


}
