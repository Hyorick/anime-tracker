package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.domain.Anime;

public interface AnimeCatalogCommandService {

  // ==========================
  // Anime
  // ==========================

  Anime createAnime(CreateAnimeRequest request);

  void patchAnime(Long animeId, PatchAnimeRequest request);

  void updateAnime(Long animeId, UpdateAnimeRequest request);

  void removeAnime(Long animeId);

  // ==========================
  // Season
  // ==========================

  void addSeason(Long animeId, CreateSeasonRequest request);

  void patchSeason(Long animeId, Long seasonId, PatchSeasonRequest request);

  void updateSeason(Long animeId, Long seasonId, UpdateSeasonRequest request);

  void removeSeason(Long animeId, Long seasonId);

  // ==========================
  // Episode
  // ==========================

  void addEpisode(Long animeId, Long seasonId, CreateEpisodeRequest request);

  void patchEpisode(Long animeId, Long seasonId, Long episodeId, PatchEpisodeRequest request);

  void updateEpisode(Long animeId, Long seasonId, Long episodeId, UpdateEpisodeRequest request);

  void removeEpisode(Long animeId, Long seasonId, Long episodeId);
}
