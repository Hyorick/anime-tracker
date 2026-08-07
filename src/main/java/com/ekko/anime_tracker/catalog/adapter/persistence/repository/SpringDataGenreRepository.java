package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataGenreRepository extends JpaRepository<GenreEntity, Long> {

  Optional<GenreEntity> findByName(String name);
}
