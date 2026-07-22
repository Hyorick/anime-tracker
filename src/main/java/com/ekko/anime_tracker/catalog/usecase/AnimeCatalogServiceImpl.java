package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.AnimeRequestMapper;
import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;

public class AnimeCatalogServiceImpl implements AnimeCatalogCommandService {

    private final AnimeRepository animeRepository;
    private final AnimeRequestMapper animeRequestMapper;

    public AnimeCatalogServiceImpl(AnimeRepository animeRepository, AnimeRequestMapper animeRequestMapper) {
        this.animeRepository = animeRepository;
        this.animeRequestMapper = animeRequestMapper;
    }



    // ==========================
    // Anime
    // ==========================
    public Anime createAnime(CreateAnimeRequest request) {

        return animeRepository.save(animeRequestMapper.toDomain(request));
        //return null;
    }

    @Override
    public void updateAnime(Long animeId, UpdateAnimeRequest request) {

    }

    @Override
    public void deleteAnime(Long animeId) {

    }

    @Override
    public void addSeason(Long animeId, CreateSeasonRequest request) {

    }

    @Override
    public void updateSeason(Long animeId, Long seasonId, UpdateSeasonRequest request) {

    }

    @Override
    public void deleteSeason(Long animeId, Long seasonId) {

    }

    @Override
    public void addEpisode(Long animeId, Long seasonId, CreateEpisodeRequest request) {

    }

    @Override
    public void updateEpisode(Long animeId, Long seasonId, Long episodeId, UpdateEpisodeRequest request) {

    }

    @Override
    public void deleteEpisode(Long animeId, Long seasonId, Long episodeId) {

    }

/*
    public Anime updateAnime(...) {

    }

    public void deleteAnime(...) {

    }

    //Season
    public void addSeason(...) {

    }

    public void updateSeason(...) {

    }

    public void removeSeason(...) {

    }

    //Episode
    public void addEpisode(...) {

    }

    public void updateEpisode(...) {

    }

    public void removeEpisode(...) {}*/
}
