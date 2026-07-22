package com.ekko.anime_tracker.catalog.adapter.web;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogQueryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogQueryController {

    private final AnimeCatalogQueryServiceImpl service;

    public CatalogQueryController(AnimeCatalogQueryServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/anime")
    public List<AnimeSummaryResponse> searchAnime(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String studio) {

        //return service.search(title, genre, studio);
        return List.of();
    }

    @GetMapping("/anime/{animeId}")
    public AnimeResponse getAnimeDetails(
            @PathVariable Long animeId) {

        //return service.getAnimeDetails(animeId);
        return null;
    }

    @GetMapping("/anime/genre/{genre}")
    public List<AnimeSummaryResponse> browseByGenre(
            @PathVariable String genre) {

        //return service.browseByGenre(genre);
        return null;
    }

    @GetMapping("/anime/studio/{studio}")
    public List<AnimeSummaryResponse> browseByStudio(
            @PathVariable String studio) {

        //return service.browseByStudio(studio);
        return null;
    }

    @GetMapping("/anime/seasonal")
    public List<AnimeSummaryResponse> browseSeasonalAnime(
            @RequestParam Integer year,
            @RequestParam String season) {

        //return service.browseSeasonalAnime(year, season);
        return null;
    }
}
