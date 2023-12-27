package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.DefaultExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.DefaultExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.DefaultExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.DefaultExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.DefaultExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.DefaultExerciseInListResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.security.JWTUtil;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DefaultExerciseService extends BaseService<DefaultExerciseResponseDTO, DefaultExerciseRequestDTO, DefaultExerciseEntity, DefaultExerciseMapper, DefaultExerciseRepository, DefaultExerciseSpecification> {
    private final DefaultExerciseRepository defaultExerciseRepository;
    private final DefaultExerciseSpecification defaultExerciseSpecification;
    JWTUtil jwtUtil;

    Logger logger = LoggerFactory.getLogger(DefaultExerciseService.class);


    @Override
    protected DefaultExerciseMapper getMapper() {
        return DefaultExerciseMapper.INSTANCE;
    }

    @Override
    protected DefaultExerciseRepository getRepository() {
        return defaultExerciseRepository;
    }

    @Override
    protected DefaultExerciseSpecification getSpecification() {
        return defaultExerciseSpecification;
    }


    public DefaultExerciseEntity findDefaultExerciseEntityFromUuid(UUID defaultExerciseUuid, List<DefaultExerciseEntity> defaultExerciseEntityList) {

        for (DefaultExerciseEntity defaultExercise : defaultExerciseEntityList) {
            if (defaultExercise.getUuid().equals(defaultExerciseUuid)) {
                return defaultExercise;
            }
        }
        logger.error("Can not find the default exercise for the given uuid");
        return null;
    }

    @Transactional
    public List<DefaultExerciseInListResponseDTO> findAllForTheUser(HttpServletRequest request) {
        UserEntity userEntity;
        userEntity = jwtUtil.findUserByRequest(request);
        if (userEntity == null) {
            logger.error("Can not find the user");
            return null;
        }
        return findAll(userEntity);
    }


    public List<DefaultExerciseInListResponseDTO> findAll(UserEntity userEntity) {
        List<DefaultExerciseEntity> defaultExerciseEntityList = userEntity.getProfile().getDefaultExerciseList();
        if (defaultExerciseEntityList != null) {
            return getMapper().listToResponseList(defaultExerciseEntityList);
        } else {
            return new ArrayList<>();
        }
    }
}
