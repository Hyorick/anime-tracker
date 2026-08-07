package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface AnimeRepository {

  Anime save(Anime anime);

  boolean exists(Long animeId);

  Optional<Anime> findById(Long id);

  Optional<Anime> findByTitle(String title);

  List<Anime> findByGenreName(String genreName);

  List<Anime> findByStudioName(String studioName);

  List<Anime> findAll();

  Page<Anime> findAll(Pageable pageable);

  Page<Anime> findAll(Specification<AnimeEntity> specification, Pageable pageable);

  void deleteById(Long id);

  void delete(Anime anime);
}
