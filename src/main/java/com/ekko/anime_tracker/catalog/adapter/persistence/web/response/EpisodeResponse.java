package com.ekko.anime_tracker.catalog.adapter.persistence.web.response;

import java.time.LocalDate;

public record EpisodeResponse(

        Long id,

        Integer episodeNumber,

        String title,

        Integer duration,

        LocalDate airDate

) { }
