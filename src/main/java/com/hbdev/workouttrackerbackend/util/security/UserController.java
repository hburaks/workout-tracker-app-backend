package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController<UserRequestDTO, UserResponseDTO, UserEntity, UserMapper, UserEntityRepository, UserSpecification, UserService> {

    private final UserService userService;

    @Override
    protected UserService getService() {
        return this.userService;
    }

}
