package com.hbdev.workouttrackerbackend.util.dbutil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;
@NoRepositoryBean
public interface BaseRepository<Entity extends BaseEntity>  extends JpaRepository<Entity, Long> {
    Optional<Entity> findByUuid(UUID uuid);
}


