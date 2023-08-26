package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.AppEntity;
import com.hbdev.workouttrackerbackend.database.repository.AppRepository;
import com.hbdev.workouttrackerbackend.database.specification.AppSpecification;
import com.hbdev.workouttrackerbackend.mapper.AppMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.AppRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.AppResponseDTO;
import com.hbdev.workouttrackerbackend.service.AppService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
@RequiredArgsConstructor
public class AppController extends BaseController<AppRequestDTO,
        AppResponseDTO,
        AppEntity,
        AppMapper,
        AppRepository,
        AppSpecification,
        AppService> {
    private final AppService appService;

    @Override
    protected AppService getService() {
        return appService;
    }
}
