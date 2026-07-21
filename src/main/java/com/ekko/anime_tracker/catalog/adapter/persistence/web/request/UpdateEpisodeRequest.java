package com.ekko.anime_tracker.catalog.adapter.persistence.web.request;

import java.time.LocalDate;

public record UpdateEpisodeRequest(

        String title,

        Integer duration,

        LocalDate airDate

) {}
