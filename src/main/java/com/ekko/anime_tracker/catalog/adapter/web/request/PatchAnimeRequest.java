package com.ekko.anime_tracker.catalog.adapter.web.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record PatchAnimeRequest(
    @Size(min = 1) String title,
    String synopsis,
    LocalDate releaseDate,
    @Size(min = 1) String studio,
    List<String> genres) {}
