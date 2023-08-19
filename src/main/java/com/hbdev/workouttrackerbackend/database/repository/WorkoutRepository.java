package com.hbdev.workouttrackerbackend.database.repository;

import com.hbdev.workouttrackerbackend.database.entity.WorkoutEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends IBaseRepository<WorkoutEntity> {
}
