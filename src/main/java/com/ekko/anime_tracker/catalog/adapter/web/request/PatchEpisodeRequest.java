package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PatchEpisodeRequest(
    @Size(min = 1) String title,
    @Positive Integer episodeNumber,
    @Positive Integer duration,
    LocalDate airDate) {}
