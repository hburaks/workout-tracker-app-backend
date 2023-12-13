package com.hbdev.workouttrackerbackend.controller;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.database.specification.ProfileSpecification;
import com.hbdev.workouttrackerbackend.mapper.ProfileMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.service.ProfileService;
import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController extends BaseController<ProfileRequestDTO,
        ProfileResponseDTO,
        ProfileEntity,
        ProfileMapper,
        ProfileRepository,
        ProfileSpecification,
        ProfileService> {
    private final ProfileService profileService;


    @Override
    protected ProfileService getService() {
        return profileService;
    }


    @GetMapping("test")
    public ResponseEntity<HttpStatus> test(){
        getService().printRequestAttribute();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
