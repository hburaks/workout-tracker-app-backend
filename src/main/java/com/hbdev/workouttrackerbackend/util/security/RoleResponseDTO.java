package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;

import java.util.List;

public class RoleResponseDTO extends BaseResponseDTO {
    private String name;
    private String description;
    private List<UserResponseDTO> users;
}
