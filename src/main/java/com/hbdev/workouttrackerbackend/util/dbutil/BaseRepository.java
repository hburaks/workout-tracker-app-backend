package com.hbdev.workouttrackerbackend.util.dbutil;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {
    Optional<Entity> findByUuid(UUID uuid);

    @Transactional
    void deleteByUuid(UUID uuid);
}