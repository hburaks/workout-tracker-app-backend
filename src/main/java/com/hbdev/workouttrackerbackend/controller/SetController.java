package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.SetRepository;
import com.hbdev.workouttrackerbackend.database.specification.SetSpecification;
import com.hbdev.workouttrackerbackend.mapper.SetMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.used.SetRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.SetResponseDTO;
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
        SetMapper,
        SetRepository,
        SetSpecification,
        SetService> {
    private final SetService setService;


    @Override
    protected SetService getService() {
        return setService;
    }


}
