package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.AnimeRequestMapper;
import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.adapter.persistence.repository.AnimeRepository;
import com.ekko.anime_tracker.catalog.domain.Season;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogCommandService;
import com.ekko.anime_tracker.catalog.usecase.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class AnimeCatalogServiceImpl implements AnimeCatalogCommandService {

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
    }

    @Override
    public void updateAnime(Long animeId, UpdateAnimeRequest request) {

    }

    @Override
    public void removeAnime(Long animeId) {

        if(!animeRepository.exists(animeId)){
            throw new ResourceNotFoundException("Anime with id %d not found".formatted(animeId));
        }

        animeRepository.deleteById(animeId);
    }

    // ==========================
    // Season
    // ==========================

    @Override
    public void addSeason(Long animeId, CreateSeasonRequest request) {

    }

    @Override
    public void updateSeason(Long animeId, Long seasonId, UpdateSeasonRequest request) {

    }

    @Transactional
    @Override
    public void removeSeason(Long animeId, Long seasonId) {
        Anime anime = animeRepository.findById(animeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Anime with id %d not found".formatted(animeId)
                        ));

        boolean removed = anime.getSeasons()
                .removeIf(
                        season -> season.getId().equals(seasonId)
                );

        if (!removed) {
            throw new ResourceNotFoundException("Season id %d not found in %s".formatted(seasonId, anime.getTitle()));
        }

        animeRepository.save(anime);
    }

    // ==========================
    // Episode
    // ==========================

    @Override
    public void addEpisode(Long animeId, Long seasonId, CreateEpisodeRequest request) {

    }

    @Override
    public void updateEpisode(Long animeId, Long seasonId, Long episodeId, UpdateEpisodeRequest request) {

    }

    @Transactional
    @Override
    public void removeEpisode(Long animeId, Long seasonId, Long episodeId) {
        Anime anime = animeRepository.findById(animeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Anime with id %d not found".formatted(animeId)
                        ));

        Season season = anime.getSeasons().stream()
                .filter(s -> s.getId().equals(seasonId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Season with id %d not found in anime '%s'"
                                        .formatted(seasonId, anime.getTitle())
                        ));

        boolean removed = season.getEpisodes()
                .removeIf(
                        episode -> episode.getId().equals(episodeId)
                );

        if (!removed) {
            throw new ResourceNotFoundException(
                    "Episode with id %d not found in season '%s' from anime '%s'"
                            .formatted(episodeId, season.getTitle(), anime.getTitle())
            );
        }

        animeRepository.save(anime);
    }

/*
    public Anime updateAnime(...) {

    }

    //Season
    public void addSeason(...) {

    }

    public void updateSeason(...) {

    }


    //Episode
    public void addEpisode(...) {

    }

    public void updateEpisode(...) {

    }

    public void removeEpisode(...) {}*/
}
