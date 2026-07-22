package com.ekko.anime_tracker.catalog.adapter.web.request;

public record UpdateAnimeRequest(

        String title,

        String synopsis,

        Integer releaseYear,

        Long studioId

) {}
