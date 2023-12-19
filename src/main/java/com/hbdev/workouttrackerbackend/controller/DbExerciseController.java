package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.service.DbExerciseService;
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
