package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;

import java.util.List;

public interface AnimeCatalogQueryService {

    List<AnimeSummaryResponse> search(
            String title,
            String genre,
            String studio);

    AnimeResponse getAnimeDetails(Long animeId);

    List<AnimeSummaryResponse> browseByGenre(String genre);

    List<AnimeSummaryResponse> browseByStudio(String studio);

    List<AnimeSummaryResponse> browseSeasonalAnime(
            Integer year,
            String season);
}
