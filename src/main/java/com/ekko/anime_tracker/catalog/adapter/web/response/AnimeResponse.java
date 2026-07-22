package com.ekko.anime_tracker.catalog.adapter.web.response;

import java.util.List;

public record AnimeResponse(

        Long id,

        String title,

        String synopsis,

        Integer releaseYear,

        String studio,

        List<String> genres,

        List<SeasonResponse> seasons
) { }
