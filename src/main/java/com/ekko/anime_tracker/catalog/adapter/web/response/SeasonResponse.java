package com.ekko.anime_tracker.catalog.adapter.web.response;

import java.time.LocalDate;
import java.util.List;

public record SeasonResponse(
    Long id,
    Integer seasonNumber,
    String title,
    String description,
    LocalDate releaseDate,
    List<EpisodeResponse> episodes) {}
