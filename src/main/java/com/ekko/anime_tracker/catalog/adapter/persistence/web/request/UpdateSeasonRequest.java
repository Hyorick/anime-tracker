package com.ekko.anime_tracker.catalog.adapter.persistence.web.request;

import java.time.LocalDate;

public record UpdateSeasonRequest(

        Integer seasonNumber,

        String title,

        LocalDate releaseDate

) {}
