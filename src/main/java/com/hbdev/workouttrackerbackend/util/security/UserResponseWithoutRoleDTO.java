package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;

import java.util.HashSet;
import java.util.Set;

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
