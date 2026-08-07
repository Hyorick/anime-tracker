package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record UpdateEpisodeRequest(
    @NotBlank String title,
    @Positive Integer episodeNumber,
    @Positive int duration,
    @NotNull LocalDate airDate) {}
