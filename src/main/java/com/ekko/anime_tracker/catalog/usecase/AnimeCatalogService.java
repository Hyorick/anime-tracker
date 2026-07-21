package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeNotFoundException;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;

public class AnimeCatalogService {

    private final AnimeRepository animeRepository;

    public AnimeCatalogService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

/*

    //Anime
    public Anime createAnime(...) {

    }

    public Anime updateAnime(...) {

    }

    public void deleteAnime(...) {

    }

    //Season
    public void addSeason(...) {

    }

    public void updateSeason(...) {

    }

    public void removeSeason(...) {

    }

    //Episode
    public void addEpisode(...) {

    }

    public void updateEpisode(...) {

    }

    public void removeEpisode(...) {}*/
}
