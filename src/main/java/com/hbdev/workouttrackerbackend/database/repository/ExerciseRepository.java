package com.hbdev.workouttrackerbackend.database.repository;

import com.hbdev.workouttrackerbackend.database.entity.ExerciseEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends IBaseRepository<ExerciseEntity> {
}
