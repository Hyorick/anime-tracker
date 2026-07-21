package com.ekko.anime_tracker.catalog.adapter.persistence.web.request;

public record CreateAnimeRequest(

        String title,

        String synopsis,

        Integer releaseYear,

        Long studioId

) {}
