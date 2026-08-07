package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PatchSeasonRequest(
    @Positive Integer seasonNumber,
    @Size(min = 1) String title,
    String description,
    LocalDate releaseDate) {}
