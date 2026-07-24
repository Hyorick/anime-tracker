package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SpringDataAnimeRepository extends JpaRepository<AnimeEntity, Long> {

    public Optional<AnimeEntity> findByTitle(String title);

    List<AnimeEntity> findByGenres_NameIgnoreCase(String genreName);

    List<AnimeEntity> findByStudio_NameIgnoreCase(String studioName);
}
