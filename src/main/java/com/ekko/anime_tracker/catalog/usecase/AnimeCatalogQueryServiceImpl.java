package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeNotFoundException;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;

import java.util.List;

public class AnimeCatalogQueryServiceImpl implements AnimeCatalogQueryService {
    private final AnimeRepository animeRepository;

    public AnimeCatalogQueryServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime getAnimeById(Long id) {//n'a rien à faire ici doit etre dans QueryService
        return animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }

    @Override
    public List<AnimeSummaryResponse> search(String title, String genre, String studio) {
        return List.of();
    }

    @Override
    public AnimeResponse getAnimeDetails(Long animeId) {
        return null;
    }

    @Override
    public List<AnimeSummaryResponse> browseByGenre(String genre) {
        return List.of();
    }

    @Override
    public List<AnimeSummaryResponse> browseByStudio(String studio) {
        return List.of();
    }

    @Override
    public List<AnimeSummaryResponse> browseSeasonalAnime(Integer year, String season) {
        return List.of();
    }
/*
    public List<Anime> search(String title) {}

    public Anime getAnimeDetails(...) {}

    public List<Anime> browseByGenre(...) {}

    public List<Anime> browseByStudio(...) {}

    public List<Anime> browseSeasonal(...) {}*/
}
