package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateAnimeRequest(

        @NotBlank
        String title,

        String synopsis,

        @NotNull
        LocalDate releaseYear,

        Long studioId

) {}
