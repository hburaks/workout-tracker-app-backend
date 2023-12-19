package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.model.responseDTO.ProfileResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.primitives.ProfileInUserResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserResponseDTO extends BaseResponseDTO {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String photoLink;

    private boolean isEnable;

    private ProfileInUserResponseDTO profile;

    private Set<PrimitiveRoleResponseDTO> roles = new HashSet<>();

}
