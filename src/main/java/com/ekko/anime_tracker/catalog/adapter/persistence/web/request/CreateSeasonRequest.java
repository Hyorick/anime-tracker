package com.ekko.anime_tracker.catalog.adapter.persistence.web.request;

import java.time.LocalDate;

public record CreateSeasonRequest(

        Integer seasonNumber,

        String title,

        LocalDate releaseDate

) {}
