package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;

public class UserResponseWithoutRoleDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private boolean isEnable;
    private ProfileResponseDTO profile;
}
