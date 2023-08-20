package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapperI;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.service.ExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exercise")
@RequiredArgsConstructor
public class ExerciseController extends BaseController<ExerciseRequestDTO,
        ExerciseResponseDTO,
        ExerciseEntity,
        ExerciseMapperI,
        ExerciseRepository,
        ExerciseService> {
    private final ExerciseService exerciseService;

    @Override
    protected ExerciseService getService() {
        return exerciseService;
    }
}
