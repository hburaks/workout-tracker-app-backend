package com.hbdev.workouttrackerbackend.database.repository;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends BaseRepository<ExercisePersonalRecordEntity> {
}
