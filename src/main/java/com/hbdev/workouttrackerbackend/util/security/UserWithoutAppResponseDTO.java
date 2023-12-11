package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserWithoutAppResponseDTO extends BaseResponseDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private boolean isEnable;
    /*
        private ProfileResponseDTO profile;
    */
    private Set<RoleWithoutUsersResponseDTO> roles = new HashSet<>();
}
