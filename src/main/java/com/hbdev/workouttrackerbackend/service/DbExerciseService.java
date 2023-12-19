package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.DbExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.DbExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.DbExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.DbExerciseMapper;
import com.hbdev.workouttrackerbackend.model.responseDTO.DbExerciseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DbExerciseService {

    private final DbExerciseRepository dbExerciseRepository;

    private final DbExerciseSpecification dbExerciseSpecification;

    private final DefaultExerciseService defaultExerciseService;

    DbExerciseMapper INSTANCE = Mappers.getMapper(DbExerciseMapper.class);


    public List<DbExerciseResponseDTO> getAll() {
        List<DbExerciseEntity> dbExerciseEntityList = dbExerciseRepository.findAll();
        if (dbExerciseEntityList.isEmpty()) {
            return null;
        } else {
            return INSTANCE.entityListToResponseDtoList(dbExerciseEntityList);
        }
    }

    //TODO: handle with pageable


}
