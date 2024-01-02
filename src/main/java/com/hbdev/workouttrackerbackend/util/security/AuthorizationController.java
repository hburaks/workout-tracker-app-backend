package com.hbdev.workouttrackerbackend.util.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        // authorizationMap.put("User", userService.getUser(body));
        return authorizationMap;
    }


    @PostMapping("register")
    public ResponseEntity<Boolean> saveUser(@RequestBody UserRequestDTO body) throws Exception {
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

    @GetMapping("findRole")
    public ResponseEntity<Set<PrimitiveRoleResponseDTO>> findRole(HttpServletRequest request) {
        Set<PrimitiveRoleResponseDTO> responseDTO = userService.findRole(request);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
