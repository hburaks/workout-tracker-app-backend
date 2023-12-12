package com.hbdev.workouttrackerbackend.database.repository;

import com.hbdev.workouttrackerbackend.database.entity.DbExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbExerciseRepository extends JpaRepository<DbExerciseEntity, Long> {
}
