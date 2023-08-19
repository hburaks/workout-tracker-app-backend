package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.mapper.SetMapperI;
import com.hbdev.workouttrackerbackend.model.SetResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.SetRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SetService extends BaseService<SetResponseDTO, SetRequestDTO, SetEntity, SetMapperI, SetRepository> {
    @Autowired
    SetRepository setRepository;


    @Override
    protected SetMapperI getBaseMapper() {
        return SetMapperI.INSTANCE;
    }

    @Override
    protected SetRepository getBaseRepository() {
        return setRepository;
    }
}

