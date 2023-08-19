package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.mapper.ProfileMapperI;
import com.hbdev.workouttrackerbackend.model.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.service.ProfileService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController extends BaseController<ProfileRequestDTO,
        ProfileResponseDTO,
        ProfileEntity,
        ProfileMapperI,
        ProfileRepository,
        ProfileService> {
    @Autowired
    ProfileService profileService;


    @Override
    protected ProfileService getService() {
        return profileService;
    }
}
