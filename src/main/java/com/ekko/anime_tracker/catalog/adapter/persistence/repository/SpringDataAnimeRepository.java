package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAnimeRepository extends JpaRepository<AnimeEntity, Long> {

    public Optional<AnimeEntity> findByTitle(String title);
}
