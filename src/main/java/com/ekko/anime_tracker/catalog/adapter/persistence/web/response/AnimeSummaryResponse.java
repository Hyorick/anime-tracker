package com.ekko.anime_tracker.catalog.adapter.persistence.web.response;

public record AnimeSummaryResponse(

        Long id,

        String title,

        Integer releaseYear,

        String studio

) {
}
