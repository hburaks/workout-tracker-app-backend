package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.database.specification.ProfileSpecification;
import com.hbdev.workouttrackerbackend.mapper.ProfileMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService extends BaseService<ProfileResponseDTO, ProfileRequestDTO, ProfileEntity, ProfileMapper, ProfileRepository, ProfileSpecification> {
    private final ProfileRepository profileRepository;
    private final ProfileSpecification profileSpecification;
    private final HttpServletRequest request;

    @Override
    protected ProfileMapper getMapper() {
        return ProfileMapper.INSTANCE;
    }

    @Override
    protected ProfileRepository getRepository() {
        return profileRepository;
    }

    @Override
    protected ProfileSpecification getSpecification() {
        return profileSpecification;
    }

    public void printRequestAttribute() {
        // Access attribute from the request
        String userEmail = (String) request.getAttribute("userEmail");
        Object userRoles = request.getAttribute("userRoles");

        System.out.println(userEmail + " " + userRoles);
    }
}
