package com.ekko.anime_tracker.catalog.domain;

public class AnimeNotFoundException extends RuntimeException {

    public AnimeNotFoundException(Long id) {
        super("Anime not found with id: " + id);
    }
}