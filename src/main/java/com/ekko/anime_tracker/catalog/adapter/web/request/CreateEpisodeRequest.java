package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreateEpisodeRequest(
//ajouter attribut sur la season
        @Positive
        int episodeNumber,

        @NotBlank
        String title,

        @Positive
        int duration,

        LocalDate airDate

) {}
