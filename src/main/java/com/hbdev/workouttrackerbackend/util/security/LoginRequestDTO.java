package com.hbdev.workouttrackerbackend.util.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    private String email;
    private String password;
}
