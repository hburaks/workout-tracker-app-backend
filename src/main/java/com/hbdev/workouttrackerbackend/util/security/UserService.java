package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.database.entity.DbExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.ProfileEntity;
import com.hbdev.workouttrackerbackend.database.repository.DbExerciseRepository;
import com.hbdev.workouttrackerbackend.database.repository.ProfileRepository;
import com.hbdev.workouttrackerbackend.util.BaseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService extends BaseService<UserResponseDTO, UserRequestDTO, UserEntity, UserMapper, UserEntityRepository, UserSpecification> {

    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final DbExerciseRepository dbExerciseRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSpecification userSpecification;
    private final ProfileRepository profileRepository;
    private final JWTUtil jwtUtil;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    protected UserMapper getMapper() {
        return UserMapper.INSTANCE;
    }

    @Override
    protected UserEntityRepository getRepository() {
        return userRepository;
    }

    @Override
    protected UserSpecification getSpecification() {
        return userSpecification;
    }

    @Transactional
    public boolean saveUserByRole(UserRequestDTO userRequestDTO) throws Exception {
        try {
            if (!isEmailExist(userRequestDTO.getEmail())) {
                UserEntity user = getMapper().requestDtoToEntity(userRequestDTO);
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
                user.setProfile(profile);
                if (!createDefaultExercisesAndAddToUser(user)) {
                    return false;
                }
                roles.add(roleEntity);
                user.setRoles(roles);
                userRepository.save(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("Error saving user: ", e);
            return false;

        }
    }

    @Transactional
    public UserResponseDTO getUserResponseDTO(LoginRequestDTO request) {
        UserEntity userEntity;
        userEntity = getRepository().findByEmail(request.getEmail()).orElse(null);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }
        return getMapper().entityToResponseDto(userEntity);
    }

    @Transactional
    public UserEntity getUser(HttpServletRequest request) {
        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }
        return userEntity;
    }

    @Transactional
    public boolean saveAdmin(UserRequestDTO userRequestDTO) {
        try {
            if (!isEmailExist(userRequestDTO.getEmail())) {
                UserEntity user = getMapper().requestDtoToEntity(userRequestDTO);
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
                ProfileEntity profile = new ProfileEntity();
                user.setProfile(profile);
                createDefaultExercisesAndAddToUser(user);
                userRepository.save(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("Error saving admin: ", e);
            return false;
        }
    }

    public boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    public boolean createDefaultExercisesAndAddToUser(UserEntity user) {
        try {
            List<DefaultExerciseEntity> defaultExerciseList = new ArrayList<>();
            ProfileEntity profile = new ProfileEntity();
            List<DbExerciseEntity> dbExerciseList = dbExerciseRepository.findAll();
            for (DbExerciseEntity dbExercise : dbExerciseList) {
                DefaultExerciseEntity defaultExercise = new DefaultExerciseEntity();
                defaultExercise.setDbExercise(dbExercise);
                defaultExercise.setProfile(profile);
                defaultExercise.setName(dbExercise.getName());
                defaultExercise.setHasDbExercise(true);
                defaultExerciseList.add(defaultExercise);
            }
            profile.setDefaultExerciseList(defaultExerciseList);
            user.setProfile(profile);
            return true;
        } catch (Exception e) {
            logger.error("Repository error", e);
            return false;
        }
    }

    public Set<PrimitiveRoleResponseDTO> findRole(HttpServletRequest request) {
        UserEntity user = jwtUtil.findUserByRequest(request);
        if (user != null) {
            return getMapper().entityToResponseDto(user).getRoles();
        } else {
            return null;
        }
    }

    public void clearCustomExerciseListWithSets(UserEntity userEntity) {
    }
}
