package com.ekko.anime_tracker.catalog.adapter.web.response;

import java.time.LocalDate;
import java.util.List;

public record AnimeSummaryResponse(

        Long id,

        String title,

        //Integer releaseYear,
        LocalDate releaseDate,

        String studio,

        List<String> genres,

        int seasonCount,

        int episodeCount

) {
}
