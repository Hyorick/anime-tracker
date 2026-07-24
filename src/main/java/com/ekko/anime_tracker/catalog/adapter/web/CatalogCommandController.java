package com.ekko.anime_tracker.catalog.adapter.web;


import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.AnimeResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogCommandController {

    private final AnimeCatalogCommandService service;
    private final AnimeResponseMapper animeResponseMapper;

    public CatalogCommandController(AnimeCatalogCommandService service, AnimeResponseMapper animeResponseMapper) {
        this.service = service;
        this.animeResponseMapper = animeResponseMapper;
    }

    // ==========================
    // Anime
    // ==========================

    @PostMapping("/animes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnimeResponse> createAnime(@RequestBody CreateAnimeRequest request) {
        Anime anime = service.createAnime(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( animeResponseMapper.toResponse(anime) );
    }

    /*@PatchMapping("/animes/{animeId}")
    public void updateAnime(
            @PathVariable Long animeId,
            @RequestBody UpdateAnimeRequest request) {

        //service.updateAnime(animeId, request);
    }*/

    @PutMapping("/animes/{animeId}")
    public void updateAnime(
            @PathVariable Long animeId,
            @RequestBody UpdateAnimeRequest request) {

        //service.updateAnime(animeId, request);
    }

    @DeleteMapping("/animes/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnime(@PathVariable Long animeId) {
        //service.deleteAnime(animeId);
    }

    // ==========================
    // Seasons
    // ==========================

    @PostMapping("/animes/{animeId}/seasons")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeason(
            @PathVariable Long animeId,
            @RequestBody CreateSeasonRequest request) {

        //service.addSeason(animeId, request);
    }

    @PutMapping("/animes/{animeId}/seasons/{seasonId}")
    public void updateSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @RequestBody UpdateSeasonRequest request) {

        //service.updateSeason(animeId, seasonId, request);
    }

    @DeleteMapping("/animes/{animeId}/seasons/{seasonId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId) {

        //service.deleteSeason(animeId, seasonId);
    }

    // ==========================
    // Episodes
    // ==========================

    @PostMapping("/animes/{animeId}/seasons/{seasonId}/episodes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @RequestBody CreateEpisodeRequest request) {

        //service.addEpisode(animeId, seasonId, request);
    }

    @PutMapping("/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    public void updateEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId,
            @RequestBody UpdateEpisodeRequest request) {

        //service.updateEpisode(animeId, seasonId, episodeId, request);
    }

    @DeleteMapping("/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId) {

        //service.deleteEpisode(animeId, seasonId, episodeId);
    }
}
