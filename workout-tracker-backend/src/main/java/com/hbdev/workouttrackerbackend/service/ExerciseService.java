package com.hbdev.workouttrackerbackend.service;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.database.repository.ExerciseRepository;
import com.hbdev.workouttrackerbackend.mapper.ExerciseMapper;
import com.hbdev.workouttrackerbackend.model.ExerciseResponseDTO;
import com.hbdev.workouttrackerbackend.model.requestDTO.ExerciseRequestDTO;
import com.hbdev.workouttrackerbackend.util.BaseService;
import com.hbdev.workouttrackerbackend.util.GenericMapper;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ExerciseService extends BaseService {
    private final ExerciseMapper exerciseMapper;
    private final ExerciseRepository exerciseRepository;
    @Override
    protected GenericMapper getBaseMapper() {
        return exerciseMapper;
    }

    @Override
    protected BaseRepository getBaseRepository() {
        return exerciseRepository;
    }

}
