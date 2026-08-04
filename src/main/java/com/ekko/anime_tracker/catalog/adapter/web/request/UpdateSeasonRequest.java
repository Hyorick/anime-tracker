package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record UpdateSeasonRequest(

        @Positive
        int seasonNumber,

        @NotBlank
        String title,

        String description,

        @NotNull
        LocalDate releaseDate,

        @NotNull
        List<CreateEpisodeRequest> episodes

) {}
