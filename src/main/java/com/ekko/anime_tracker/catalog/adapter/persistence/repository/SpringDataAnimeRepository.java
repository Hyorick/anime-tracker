package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

interface SpringDataAnimeRepository
    extends JpaRepository<AnimeEntity, Long>,
        PagingAndSortingRepository<AnimeEntity, Long>,
        JpaSpecificationExecutor<AnimeEntity> {

  public Optional<AnimeEntity> findByTitle(String title);

  List<AnimeEntity> findByGenres_NameIgnoreCase(String genreName);

  List<AnimeEntity> findByStudio_NameIgnoreCase(String studioName);
}
