package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimitiveUserResponseDTO extends BaseResponseDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String photoLink;

    private boolean isEnable;

}
