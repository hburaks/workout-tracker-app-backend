package com.hbdev.workouttrackerbackend.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;


    public void saveUserByRole(UserRequestDTO userRequestDTO) {
        UserEntity user = userMapper.requestDtoToEntity(userRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = roleRepository.findByName("user").orElse(null);
        if (roleEntity == null) {
            roleEntity = new RoleEntity();
            roleEntity.setName("user");
            roleEntity = roleRepository.save(roleEntity);
        }
        roles.add(roleEntity);
        user.setRoles(roles);
        userRepository.save(user);
    }


}
