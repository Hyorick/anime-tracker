package com.ekko.anime_tracker.catalog.adapter.persistence.web.response;

import java.time.LocalDate;
import java.util.List;

public record SeasonResponse(

        Long id,

        Integer seasonNumber,

        String title,

        LocalDate releaseDate,

        List<EpisodeResponse> episodes

) { }
