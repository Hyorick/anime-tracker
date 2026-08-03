package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.domain.Anime;

public interface AnimeCatalogCommandService {

    Anime createAnime(CreateAnimeRequest request);

    void updateAnime(Long animeId, UpdateAnimeRequest request);

    void removeAnime(Long animeId);

    void addSeason(Long animeId, CreateSeasonRequest request);

    void updateSeason(Long animeId, Long seasonId, UpdateSeasonRequest request);

    void removeSeason(Long animeId, Long seasonId);

    void addEpisode(Long animeId, Long seasonId, CreateEpisodeRequest request);

    void updateEpisode(Long animeId,
                       Long seasonId,
                       Long episodeId,
                       UpdateEpisodeRequest request);

    void removeEpisode(Long animeId,
                       Long seasonId,
                       Long episodeId);
}
