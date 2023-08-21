package com.hbdev.workouttrackerbackend.util.security;

import com.hbdev.workouttrackerbackend.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
