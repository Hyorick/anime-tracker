package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeCatalogQueryServiceImpl implements AnimeCatalogQueryService {
    private final AnimeRepository animeRepository;

    public AnimeCatalogQueryServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public List<AnimeSummaryResponse> search(String title, String genre, String studio) {
        return List.of();
    }

    @Override
    public Optional<Anime> getAnimeDetails(Long animeId) {
        return animeRepository.findById(animeId);
    }

    @Override
    public List<Anime> searchByGenreName(String genre) {

        return animeRepository.findByGenreName(genre);
    }

    @Override
    public List<Anime> searchByStudioName(String studio) {

        return animeRepository.findByStudioName(studio);
    }

    @Override
    public List<AnimeSummaryResponse> browseSeasonalAnime(Integer year, String season) {
        return List.of();
    }
/*
    public List<Anime> search(String title) {}

    public List<Anime> browseSeasonal(...) {}*/
}
