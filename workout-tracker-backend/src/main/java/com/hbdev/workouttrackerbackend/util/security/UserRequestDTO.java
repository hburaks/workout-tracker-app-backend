package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.model.requestDTO.ProfileRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseRequestDTO;
import lombok.Data;

@Data
public class UserRequestDTO extends BaseRequestDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String photoLink;
    private ProfileRequestDTO profileRequestDTO;
    private Long appId;
}
