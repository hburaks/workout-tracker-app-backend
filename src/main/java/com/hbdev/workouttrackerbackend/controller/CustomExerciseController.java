package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.CustomExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.CustomExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.CustomExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.CustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.service.CustomExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workout-exercise")
@RequiredArgsConstructor
public class CustomExerciseController extends BaseController<CustomExerciseRequestDTO, CustomExerciseResponseDTO, CustomExerciseEntity, CustomExerciseMapper, CustomExerciseRepository, CustomExerciseSpecification, CustomExerciseService> {
    private final CustomExerciseService customExerciseService;


    @Override
    protected CustomExerciseService getService() {
        return customExerciseService;
    }

    //TODO ilişki kontrolünden devam
}
