package com.ekko.anime_tracker.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository {

    Anime save(Anime anime);

    Optional<Anime> findById(Long id);

    Optional<Anime> findByTitle(String title);

    List<Anime> findByGenreName(String genreName);

    List<Anime> findByStudioName(String studioName);

    List<Anime> findAll();

    void deleteById(Long id);

    void delete(Anime anime);
}
