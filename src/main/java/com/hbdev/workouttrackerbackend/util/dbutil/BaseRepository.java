package com.hbdev.workouttrackerbackend.util.dbutil;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    Optional<T> findByUuid(UUID uuid);

    @Transactional
    void deleteByUuid(UUID uuid);
}