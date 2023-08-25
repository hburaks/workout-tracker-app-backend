package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Transactional
    public boolean saveUserByRole(UserRequestDTO userRequestDTO) {
        if (!isEmailExist(userRequestDTO.getEmail())) {
            UserEntity user = userMapper.requestDtoToEntity(userRequestDTO);
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("user").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("user");
                roleEntity = roleRepository.save(roleEntity);
            }
            ProfileEntity profile = new ProfileEntity();
            profileRepository.save(profile);
            user.setProfile(profile);
            roles.add(roleEntity);
            user.setRoles(roles);
            profile.setUser(user);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean saveAdmin(UserRequestDTO userRequestDTO) {
        if (!isEmailExist(userRequestDTO.getEmail())) {
            UserEntity user = userMapper.requestDtoToEntity(userRequestDTO);
            user.setEnable(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<RoleEntity> roles = new HashSet<>();
            RoleEntity roleEntity = roleRepository.findByName("admin").orElse(null);
            if (roleEntity == null) {
                roleEntity = new RoleEntity();
                roleEntity.setName("admin");
                roleEntity = roleRepository.save(roleEntity);
            }
            roles.add(roleEntity);
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


}
