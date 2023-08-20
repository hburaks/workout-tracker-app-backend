package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.mapper.ProfileMapperI;
import com.hbdev.workouttrackerbackend.model.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService extends BaseService<ProfileResponseDTO, ProfileRequestDTO, ProfileEntity, ProfileMapperI, ProfileRepository> {
    private final ProfileRepository profileRepository;


    @Override
    protected ProfileMapperI getBaseMapper() {
        return ProfileMapperI.INSTANCE;
    }

    @Override
    protected ProfileRepository getBaseRepository() {
        return profileRepository;
    }

}
