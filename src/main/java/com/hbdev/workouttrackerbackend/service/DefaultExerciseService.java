package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.CustomExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.DefaultExerciseEntity;
import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.repository.DefaultExerciseRepository;
import com.hbdev.workouttrackerbackend.database.specification.DefaultExerciseSpecification;
import com.hbdev.workouttrackerbackend.mapper.DefaultExerciseMapper;
import com.hbdev.workouttrackerbackend.model.requestDTO.DefaultExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.DefaultExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.responseDTO.checked.DefaultExerciseInListResponseDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.security.UserEntity;
import com.hbdev.workouttrackerbackend.util.security.UserEntityRepository;
import com.hbdev.workouttrackerbackend.util.security.UserService;
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
    private final UserEntityRepository userEntityRepository;
    private final UserService userService;
    private final SetService setService;

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
        UserEntity userEntity = userService.getUser(request);
        List<DefaultExerciseEntity> defaultExerciseEntityList = userEntity.getProfile().getDefaultExerciseList();
        if (defaultExerciseEntityList != null) {
            return getMapper().listToResponseList(defaultExerciseEntityList);
        } else {
            return new ArrayList<>();
        }
    }


    public DefaultExerciseResponseDTO createNewDefaultExercise(HttpServletRequest request, DefaultExerciseRequestDTO requestDTO) {
        UserEntity userEntity = userService.getUser(request);
        DefaultExerciseEntity defaultExercise = new DefaultExerciseEntity();
        defaultExercise.setName(requestDTO.getName());
        defaultExercise.setNote(requestDTO.getNote());
        defaultExercise.setHasDbExercise(false);

        userEntity.getProfile().getDefaultExerciseList().add(defaultExercise);

        defaultExercise.setProfile(userEntity.getProfile());

        DefaultExerciseEntity savedExercise = defaultExerciseRepository.saveAndFlush(defaultExercise);

        return getMapper().entityToResponseDto(savedExercise);


    }

    public void updateDefaultExerciseRm1(CustomExerciseEntity customExerciseEntity) {
        Double oneRMofExercise = 0.0;
        for (SetEntity set : customExerciseEntity.getSets()) {
            Double oneRMofSet = setService.calculateOneRM(set);
            if (oneRMofSet > oneRMofExercise) {
                oneRMofExercise = oneRMofSet;
            }
        }
        if (customExerciseEntity.getDefaultExercise().getRm1() == null) {
            customExerciseEntity.getDefaultExercise().setRm1(0.0);
        }
        if (oneRMofExercise > customExerciseEntity.getDefaultExercise().getRm1()) {
            customExerciseEntity.getDefaultExercise().setRm1(oneRMofExercise);
        }
    }
}
