package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.database.specification.SetSpecification;
import com.hbdev.workouttrackerbackend.mapper.SetMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SetService extends BaseService<SetResponseDTO, SetRequestDTO, SetEntity, SetMapper, SetRepository, SetSpecification> {
    private final SetRepository setRepository;
    private final SetSpecification setSpecification;


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

    public List<SetEntity> requestListToEntityList(List<SetRequestDTO> requestDTOList) {
        // TODO: may cause error from initial false value
        return getMapper().requestListToEntityList(requestDTOList);
        /*List<SetEntity> setEntities = new ArrayList<>();
        for (SetRequestDTO requestDTO : requestDTOList) {
            SetEntity set = new SetEntity();
            set.setReps(requestDTO.getReps());
            set.setWeight(requestDTO.getWeight());
            set.setSetTypeEnum(requestDTO.getSetTypeEnum());
            set.setWeightUnitTypeEnum(requestDTO.getWeightUnitTypeEnum());
            setEntities.add(set);
        }
        return setEntities;*/
    }
}

