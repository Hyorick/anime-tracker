package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.AnimeRequestMapper;
import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.EpisodeRequestMapper;
import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.SeasonRequestMapper;
import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.adapter.persistence.repository.AnimeRepository;
import com.ekko.anime_tracker.catalog.domain.Episode;
import com.ekko.anime_tracker.catalog.domain.Season;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogCommandService;
import com.ekko.anime_tracker.catalog.usecase.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class AnimeCatalogServiceImpl implements AnimeCatalogCommandService {

    private final AnimeRepository animeRepository;
    private final AnimeRequestMapper animeRequestMapper;
    private final SeasonRequestMapper seasonRequestMapper;
    private final EpisodeRequestMapper episodeRequestMapper;

    public AnimeCatalogServiceImpl(AnimeRepository animeRepository, AnimeRequestMapper animeRequestMapper, SeasonRequestMapper seasonRequestMapper, EpisodeRequestMapper episodeRequestMapper) {
        this.animeRepository = animeRepository;
        this.animeRequestMapper = animeRequestMapper;
        this.seasonRequestMapper = seasonRequestMapper;
        this.episodeRequestMapper = episodeRequestMapper;
    }


    // ==========================
    // Anime
    // ==========================

    public Anime createAnime(CreateAnimeRequest request) {
        return animeRepository.save(animeRequestMapper.toDomain(request));
    }

    @Transactional
    @Override
    public void patchAnime(Long animeId, PatchAnimeRequest request) {
        Anime anime = animeRepository.findById(animeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Anime with id %d not found".formatted(animeId)
                        ));

        animeRequestMapper.patchAnime(request, anime);

        animeRepository.save(anime);
    }

    @Transactional
    @Override
    public void updateAnime(Long animeId, UpdateAnimeRequest request) {
        Anime anime = animeRepository.findById(animeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Anime with id %d not found".formatted(animeId)
                        ));

        animeRequestMapper.updateAnime(request, anime);

        animeRepository.save(anime);
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

    @Transactional
    @Override
    public void addSeason(Long animeId, CreateSeasonRequest request) {
        Anime anime = animeRepository.findById(animeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Anime with id %d not found".formatted(animeId)
                        ));
        anime.getSeasons().add(seasonRequestMapper.toDomain(request));

        animeRepository.save(anime);
    }

    @Transactional
    @Override
    public void patchSeason(Long animeId, Long seasonId, PatchSeasonRequest request) {
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

        seasonRequestMapper.patchSeason(request, season);

        animeRepository.save(anime);
    }

    @Transactional
    @Override
    public void updateSeason(Long animeId, Long seasonId, UpdateSeasonRequest request) {
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

        seasonRequestMapper.updateSeason(request, season);

        //manually replacing the episodes collection with the ones from the request
        season.getEpisodes().clear();

        season.getEpisodes().addAll(
                request.episodes()
                        .stream()
                        .map(episodeRequestMapper::toDomain)
                        .toList()
        );

        animeRepository.save(anime);
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

    @Transactional
    @Override
    public void addEpisode(Long animeId, Long seasonId, CreateEpisodeRequest request) {
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
        season.getEpisodes().add(episodeRequestMapper.toDomain(request));

        animeRepository.save(anime);
    }

    @Transactional
    @Override
    public void patchEpisode(Long animeId, Long seasonId, Long episodeId, PatchEpisodeRequest request) {
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

        Episode episode = season.getEpisodes().stream()
                .filter(e -> e.getId().equals(episodeId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Episode with id %d not found in season %d"
                                        .formatted(episodeId, seasonId)
                        ));

        episodeRequestMapper.patchEpisode(request, episode);

        animeRepository.save(anime);
    }

    @Transactional
    @Override
    public void updateEpisode(Long animeId, Long seasonId, Long episodeId, UpdateEpisodeRequest request) {
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

        Episode episode = season.getEpisodes().stream()
                .filter(e -> e.getId().equals(episodeId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Episode with id %d not found in season %d"
                                        .formatted(episodeId, seasonId)
                        ));

        episodeRequestMapper.updateEpisode(request, episode);

        animeRepository.save(anime);
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
*/
}
