package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.mapper.SetMapperI;
import com.hbdev.workouttrackerbackend.model.SetResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.SetRequestDTO;
import com.hbdev.workouttrackerbackend.service.SetService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("set")
@RequiredArgsConstructor
public class SetController extends BaseController<SetRequestDTO,
        SetResponseDTO,
        SetEntity,
        SetMapperI,
        SetRepository,
        SetService> {
    private final SetService setService;


    @Override
    protected SetService getService() {
        return setService;
    }
}
