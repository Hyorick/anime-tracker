package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataGenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByName(String name);

}
