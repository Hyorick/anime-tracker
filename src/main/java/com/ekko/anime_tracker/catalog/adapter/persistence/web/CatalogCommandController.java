package com.ekko.anime_tracker.catalog.adapter.persistence.web;


import com.ekko.anime_tracker.catalog.adapter.persistence.web.request.*;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogCommandController {

    private final AnimeCatalogService service;

    public CatalogCommandController(AnimeCatalogService service) {
        this.service = service;
    }

    // ==========================
    // Anime
    // ==========================

    @PostMapping("/anime")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnime(@RequestBody CreateAnimeRequest request) {
        //service.createAnime(request);
    }

    @PutMapping("/anime/{animeId}")
    public void updateAnime(
            @PathVariable Long animeId,
            @RequestBody UpdateAnimeRequest request) {

        //service.updateAnime(animeId, request);
    }

    @DeleteMapping("/anime/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnime(@PathVariable Long animeId) {
        //service.deleteAnime(animeId);
    }

    // ==========================
    // Seasons
    // ==========================

    @PostMapping("/anime/{animeId}/seasons")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeason(
            @PathVariable Long animeId,
            @RequestBody CreateSeasonRequest request) {

        //service.addSeason(animeId, request);
    }

    @PutMapping("/anime/{animeId}/seasons/{seasonId}")
    public void updateSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @RequestBody UpdateSeasonRequest request) {

        //service.updateSeason(animeId, seasonId, request);
    }

    @DeleteMapping("/anime/{animeId}/seasons/{seasonId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId) {

        //service.deleteSeason(animeId, seasonId);
    }

    // ==========================
    // Episodes
    // ==========================

    @PostMapping("/anime/{animeId}/seasons/{seasonId}/episodes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @RequestBody CreateEpisodeRequest request) {

        //service.addEpisode(animeId, seasonId, request);
    }

    @PutMapping("/anime/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    public void updateEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId,
            @RequestBody UpdateEpisodeRequest request) {

        //service.updateEpisode(animeId, seasonId, episodeId, request);
    }

    @DeleteMapping("/anime/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId) {

        //service.deleteEpisode(animeId, seasonId, episodeId);
    }
}
