package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.database.specification.SetSpecification;
import com.hbdev.workouttrackerbackend.mapper.SetMapper;
import com.hbdev.workouttrackerbackend.model.enums.WeightUnitTypeEnum;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SetService extends BaseService<SetResponseDTO, SetRequestDTO, SetEntity, SetMapper, SetRepository, SetSpecification> {
    private final SetRepository setRepository;
    private final SetSpecification setSpecification;
    Logger logger = LoggerFactory.getLogger(SetService.class);


    @Override
    protected SetMapper getMapper() {
        return SetMapper.INSTANCE;
    }

    @Override
    protected SetRepository getRepository() {
        return setRepository;
    }

    @Override
    protected SetSpecification getSpecification() {
        return setSpecification;
    }

    public Double calculateVolumeOfSets(List<SetEntity> sets) {
        Double volume = 0.0;
        int i = 0;
        for (SetEntity set : sets) {
            if (set.getWeightUnitTypeEnum() == null || set.getReps() == null) {
                logger.error("Weight type or rep count is null for the set with index: " + i);
                i++;
                continue;
            }
            Double weightOfTheSet = set.getWeight();
            if (set.getWeightUnitTypeEnum().equals(WeightUnitTypeEnum.LB)) {
                weightOfTheSet *= 0.453592;
            }

            volume += weightOfTheSet * set.getReps();
            i++;
        }
        return volume;
    }

    public List<SetEntity> copySetList(List<SetEntity> setListToCopy, CustomExerciseEntity customExerciseEntity) {
        List<SetEntity> newSetList = new ArrayList<>();
        for (SetEntity set : setListToCopy) {
            SetEntity newSet = copySet(set);
            newSet.setCustomExercise(customExerciseEntity);
            newSetList.add(newSet);
        }
        return newSetList;
    }

    public SetEntity copySet(SetEntity setToCopy) {
        SetEntity newSet = new SetEntity();

        newSet.setWeight(setToCopy.getWeight());
        newSet.setReps(setToCopy.getReps());
        newSet.setSetTypeEnum(setToCopy.getSetTypeEnum());
        newSet.setWeightUnitTypeEnum(setToCopy.getWeightUnitTypeEnum());

        return newSet;
    }

    public List<SetEntity> mapSetsWithCustomExercise(List<SetRequestDTO> setRequestDTOList, CustomExerciseEntity customExercise) {
        List<SetEntity> setEntityList = new ArrayList<>();
        for (SetRequestDTO setRequestDTO : setRequestDTOList) {
            SetEntity set = getMapper().requestDtoToEntity(setRequestDTO);
            set.setCustomExercise(customExercise);
            setEntityList.add(set);
        }
        return setEntityList;
    }

    public Double calculateOneRM(SetEntity set) {
        Double weight = set.getWeight();
        int reps = set.getReps();
        Double oneRm = weight / (1.0278 - 0.0278 * reps);
        return oneRm;
    }

}

