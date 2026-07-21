package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeNotFoundException;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;

public class AnimeCatalogQueryService {
    private final AnimeRepository animeRepository;

    public AnimeCatalogQueryService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime getAnimeById(Long id) {//n'a rien à faire ici doit etre dans QueryService
        return animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }
/*
    public List<Anime> search(String title) {}

    public Anime getAnimeDetails(...) {}

    public List<Anime> browseByGenre(...) {}

    public List<Anime> browseByStudio(...) {}

    public List<Anime> browseSeasonal(...) {}*/
}
