package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataStudioRepository
        extends JpaRepository<StudioEntity, Long> {

    Optional<StudioEntity> findByName(String name);

}
