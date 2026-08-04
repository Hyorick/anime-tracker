package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateAnimeRequest(

        @NotBlank
        String title,

        String synopsis,

        @NotNull
        LocalDate releaseDate/* mettre releaseYear*/,

        @NotBlank
        String studio,

        @NotEmpty
        List<String> genres,

        @NotNull
        List<CreateSeasonRequest> seasons

) {}
