package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.mapper.ProfileMapperI;
import com.hbdev.workouttrackerbackend.model.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.service.ProfileService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController extends BaseController<ProfileRequestDTO,
        ProfileResponseDTO,
        ProfileEntity,
        ProfileMapperI,
        ProfileRepository,
        ProfileService> {
    private final ProfileService profileService;


    @Override
    protected ProfileService getService() {
        return profileService;
    }


}
