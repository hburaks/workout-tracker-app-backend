package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.CustomExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.CustomExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.CustomExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.CustomExerciseRequestDTOWithDbName;
import com.hbdev.workouttrackerbackend.model.responseDTO.CustomExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomExerciseService extends BaseService<CustomExerciseResponseDTO, CustomExerciseRequestDTOWithDbName, CustomExerciseEntity, CustomExerciseMapper, CustomExerciseRepository, CustomExerciseSpecification> {
    private final CustomExerciseRepository customExerciseRepository;
    private final CustomExerciseSpecification customExerciseSpecification;
    private final SetService setService;
    private final DefaultExerciseService defaultExerciseService;

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


    public CustomExerciseEntity createCustomExerciseFromExisting(CustomExerciseEntity other) {
        CustomExerciseEntity customExerciseEntity = new CustomExerciseEntity();
        customExerciseEntity.setRestTime(other.getRestTime());
        customExerciseEntity.setNote(other.getNote());

        customExerciseEntity.setDefaultExercise(other.getDefaultExercise());
        customExerciseEntity.setProfile(other.getProfile());

        List<SetEntity> copiedSetList = setService.copySetList(other.getSets(), customExerciseEntity);
        customExerciseEntity.setSets(copiedSetList);

        return customExerciseEntity;

    }

    public CustomExerciseEntity createCustomExerciseFromDefaultExercise(DefaultExerciseEntity defaultExercise) {
        CustomExerciseEntity customExerciseEntity = new CustomExerciseEntity();
        customExerciseEntity.setSets(new ArrayList<>());
        customExerciseEntity.setDefaultExercise(defaultExercise);
        customExerciseEntity.setProfile(defaultExercise.getProfile());

        return customExerciseEntity;
    }

    public Double calculateVolumeOfCustomExerciseListAndUpdateRm1(List<CustomExerciseEntity> customExerciseList) {
        Double volumeOfList = 0.0;
        for (CustomExerciseEntity customExercise : customExerciseList) {
            defaultExerciseService.updateDefaultExerciseRm1(customExercise);
            Double volumeOfExercise = setService.calculateVolumeOfSets(customExercise.getSets());
            customExercise.setVolume(volumeOfExercise);

            volumeOfList += customExercise.getVolume();
        }
        return volumeOfList;
    }

    public CustomExerciseEntity setRequestVariablesToEntity(CustomExerciseRequestDTOWithDbName customExerciseRequestDTOWithDbName, CustomExerciseEntity customExerciseEntity) {

        if (customExerciseRequestDTOWithDbName.isNoteForGeneral()) {
            customExerciseEntity.getDefaultExercise().setNote(customExerciseRequestDTOWithDbName.getNote());
        } else {
            customExerciseEntity.setNote(customExerciseRequestDTOWithDbName.getNote());
        }

        customExerciseEntity.setRestTime(customExerciseRequestDTOWithDbName.getRestTime());

        List<SetEntity> setEntityList = setService.mapSetsWithCustomExercise(customExerciseRequestDTOWithDbName.getSets(), customExerciseEntity);
        customExerciseEntity.getSets().addAll(setEntityList);

        return customExerciseEntity;
    }
}
