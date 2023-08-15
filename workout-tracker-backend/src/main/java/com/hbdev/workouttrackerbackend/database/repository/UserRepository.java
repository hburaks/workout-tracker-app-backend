package com.hbdev.workouttrackerbackend.database.repository;

import com.hbdev.workouttrackerbackend.database.entity.SetEntity;
import com.hbdev.workouttrackerbackend.database.entity.UserEntity;
import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
}
