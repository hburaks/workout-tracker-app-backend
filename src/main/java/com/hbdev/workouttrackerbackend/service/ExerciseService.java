package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapperI;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExerciseService extends BaseService<ExerciseResponseDTO, ExerciseRequestDTO, ExerciseEntity, ExerciseMapperI, ExerciseRepository> {
    private final ExerciseRepository exerciseRepository;


    @Override
    protected ExerciseMapperI getBaseMapper() {
        return ExerciseMapperI.INSTANCE;
    }

    @Override
    protected ExerciseRepository getBaseRepository() {
        return exerciseRepository;
    }
}
