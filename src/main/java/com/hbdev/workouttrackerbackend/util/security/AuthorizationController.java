package com.hbdev.workouttrackerbackend.util.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthorizationController {


    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JWTUtil jwtUtil;

    @PostMapping("login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestDTO body) {
        UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());
        authManager.authenticate(authInputToken);
        String token = jwtUtil.generateToken(body.getEmail());
        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("jwt-token", token);
        return authorizationMap;
    }


    @PostMapping("register")
    public ResponseEntity<Boolean> saveUser(@RequestBody UserRequestDTO body) {
        boolean isSaved = userService.saveUserByRole(body);
        if (isSaved) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("admin/register")
    public ResponseEntity<Boolean> saveAdmin(@RequestBody UserRequestDTO body) {
        boolean isSaved = userService.saveAdmin(body);
        if (isSaved) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
