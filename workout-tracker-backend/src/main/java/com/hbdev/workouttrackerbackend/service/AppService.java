package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.AppEntity;
import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.AppRepository;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.AppSpecification;
import com.hbdev.workouttrackerbackend.database.specification.ExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.AppMapper;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.AppRequestDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.AppResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppService extends BaseService<AppResponseDTO, AppRequestDTO, AppEntity, AppMapper, AppRepository, AppSpecification> {
    private final AppRepository appRepository;
    private final AppSpecification appSpecification;


    @Override
    protected AppMapper getMapper() {
        return AppMapper.INSTANCE;
    }

    @Override
    protected AppRepository getRepository() {
        return appRepository;
    }

    @Override
    protected AppSpecification getSpecification() {
        return appSpecification;
    }


}
