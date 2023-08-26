package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
