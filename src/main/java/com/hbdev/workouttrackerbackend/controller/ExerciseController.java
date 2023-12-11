package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.ExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.service.ExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exercise")
@RequiredArgsConstructor
public class ExerciseController extends BaseController<ExerciseRequestDTO,
        ExerciseResponseDTO,
        ExercisePersonalRecordEntity,
        ExerciseMapper,
        ExerciseRepository,
        ExerciseSpecification,
        ExerciseService> {
    private final ExerciseService exerciseService;

    @Override
    protected ExerciseService getService() {
        return exerciseService;
    }
}
