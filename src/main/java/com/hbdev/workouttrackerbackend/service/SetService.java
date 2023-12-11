package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.database.specification.SetSpecification;
import com.hbdev.workouttrackerbackend.mapper.SetMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
}

