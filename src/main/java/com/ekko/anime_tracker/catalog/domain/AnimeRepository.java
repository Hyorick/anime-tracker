package com.ekko.anime_tracker.catalog.domain;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository {

    Anime save(Anime anime);

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
