package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateSeasonRequest(

        @NotNull
        Integer seasonNumber,

        @NotBlank
        String title,

        @NotNull
        LocalDate releaseDate,

        List<CreateEpisodeRequest> episodes

) {}
