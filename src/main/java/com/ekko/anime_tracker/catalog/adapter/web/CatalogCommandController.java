package com.ekko.anime_tracker.catalog.adapter.web;


import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.AnimeResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.request.*;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogCommandService;
import jakarta.validation.Valid;
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
    public ResponseEntity<AnimeResponse> createAnime(@Valid @RequestBody CreateAnimeRequest request) {
        Anime anime = service.createAnime(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( animeResponseMapper.toResponse(anime) );
    }

    @PatchMapping("/animes/{animeId}")
    public ResponseEntity<String> patchAnime(
            @PathVariable Long animeId,
            @Valid @RequestBody PatchAnimeRequest request) {

        service.patchAnime(animeId, request);
        return ResponseEntity.ok("Anime id %d patched successfully".formatted(animeId));
    }

    @PutMapping("/animes/{animeId}")
    public void updateAnime(
            @PathVariable Long animeId,
            @Valid @RequestBody UpdateAnimeRequest request) {

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
    public ResponseEntity<String> addSeason(
            @PathVariable Long animeId,
            @Valid @RequestBody CreateSeasonRequest request) {

        service.addSeason(animeId, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Season '%s' added successfully in Anime id %d".formatted(request.title(), animeId));
    }

    @PatchMapping("/animes/{animeId}/seasons/{seasonId}")
    public ResponseEntity<String> patchSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @Valid @RequestBody PatchSeasonRequest request) {

        service.patchSeason(animeId, seasonId, request);
        return ResponseEntity.ok("Season id %d patched successfully in Anime id %d"
                .formatted(seasonId, animeId)
        );
    }

    @PutMapping("/animes/{animeId}/seasons/{seasonId}")
    public ResponseEntity<String> updateSeason(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @Valid @RequestBody UpdateSeasonRequest request) {

        service.updateSeason(animeId, seasonId, request);
        return ResponseEntity.ok("Season id %d updated successfully in Anime id %d".formatted(seasonId, animeId));
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
    public ResponseEntity<String> addEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @Valid @RequestBody CreateEpisodeRequest request) {

        service.addEpisode(animeId, seasonId, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Episode '%s' added successfully in Season id %d of Anime id %d".formatted(request.title(), seasonId, animeId));
    }

    @PatchMapping("/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    public ResponseEntity<String> patchEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId,
            @Valid @RequestBody PatchEpisodeRequest request) {

        service.patchEpisode(animeId, seasonId, episodeId, request);
        return ResponseEntity.ok("Episode id %d patched successfully in Season id %d of Anime id %d"
                        .formatted(episodeId, seasonId, animeId)
        );
    }

    @PutMapping("/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    public ResponseEntity<String> updateEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId,
            @Valid @RequestBody UpdateEpisodeRequest request) {

        service.updateEpisode(animeId, seasonId, episodeId, request);
        return ResponseEntity.ok("Episode id %d updated successfully in Season id %d of Anime id %d".formatted(episodeId, seasonId, animeId));
    }

    @DeleteMapping("/animes/{animeId}/seasons/{seasonId}/episodes/{episodeId}")
    public ResponseEntity<String> deleteEpisode(
            @PathVariable Long animeId,
            @PathVariable Long seasonId,
            @PathVariable Long episodeId) {

        service.removeEpisode(animeId, seasonId, episodeId);
        return ResponseEntity.ok("Episode id %d deleted successfully in Season id %d of Anime id %d".formatted(episodeId, seasonId, animeId));
    }
}
