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
    public ResponseEntity<String> deleteAnime(@PathVariable Long animeId) {
        service.removeAnime(animeId);
        return ResponseEntity.ok("Anime deleted successfully");
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
    public ResponseEntity<String> deleteSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId) {

        service.removeSeason(animeId, seasonId);
        return ResponseEntity.ok("Season id %d deleted successfully from Anime id %d".formatted(seasonId, animeId));
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
    public ResponseEntity<String> deleteEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId) {

        service.removeEpisode(animeId, seasonId, episodeId);
        return ResponseEntity.ok("Episode id %d deleted successfully in Season id %d from Anime id %d".formatted(episodeId, seasonId, animeId));
    }
}
