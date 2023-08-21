package com.hbdev.workouttrackerbackend.util.security;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity requestDtoToEntity(UserRequestDTO userRequestDTO) {
        UserEntity user = new UserEntity();
        user.setPassword(userRequestDTO.getPassword());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setUsername(userRequestDTO.getUsername());
        user.setPhotoLink(userRequestDTO.getPhotoLink());
        return user;
    }
}
