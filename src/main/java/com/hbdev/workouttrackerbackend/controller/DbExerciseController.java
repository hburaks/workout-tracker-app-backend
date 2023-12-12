package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.CustomExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.CustomExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.CustomExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.WorkoutExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTOChecked.DbExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.service.CustomExerciseService;
import com.hbdev.workouttrackerbackend.service.DbExerciseService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exercise")
@RequiredArgsConstructor
public class DbExerciseController {
    private final DbExerciseService dbExerciseService;

    @GetMapping("get-all")
    public ResponseEntity<List<DbExerciseResponseDTO>> getAll(){
        return new ResponseEntity<>(dbExerciseService.getAll(), HttpStatus.OK) ;
    }

}
