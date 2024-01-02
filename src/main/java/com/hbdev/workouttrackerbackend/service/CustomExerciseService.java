package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.CustomExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.CustomExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.CustomExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.CustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomExerciseService extends BaseService<CustomExerciseResponseDTO, CustomExerciseRequestDTO, CustomExerciseEntity, CustomExerciseMapper, CustomExerciseRepository, CustomExerciseSpecification> {
    private final CustomExerciseRepository customExerciseRepository;
    private final CustomExerciseSpecification customExerciseSpecification;
    private final SetService setService;

    @Override
    protected CustomExerciseMapper getMapper() {
        return CustomExerciseMapper.INSTANCE;
    }

    @Override
    protected CustomExerciseRepository getRepository() {
        return customExerciseRepository;
    }

    @Override
    protected CustomExerciseSpecification getSpecification() {
        return customExerciseSpecification;
    }


    public Double calculateVolumeOfCustomExerciseList(List<CustomExerciseEntity> customExerciseList) {
        Double volumeOfList = 0.0;
        for (CustomExerciseEntity customExercise : customExerciseList) {
            Double volumeOfExercise = setService.calculateVolumeOfSets(customExercise.getSets());
            customExercise.setVolume(volumeOfExercise);

            volumeOfList += customExercise.getVolume();
        }
        return volumeOfList;
    }
}
