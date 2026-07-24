package com.ekko.anime_tracker.catalog.adapter.web;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.AnimeResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.SummaryResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.usecase.impl.AnimeCatalogQueryServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog")
public class CatalogQueryController {

    private final AnimeCatalogQueryServiceImpl service;
    private final AnimeResponseMapper animeResponseMapper;
    private final SummaryResponseMapper summaryMapper;

    public CatalogQueryController(AnimeCatalogQueryServiceImpl service, AnimeResponseMapper animeResponseMapper, SummaryResponseMapper summaryMapper) {
        this.service = service;
        this.animeResponseMapper = animeResponseMapper;
        this.summaryMapper = summaryMapper;
    }

    @GetMapping("/animes")
    public List<AnimeSummaryResponse> searchAnime(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String studio) {

        //return service.search(title, genre, studio);
        return List.of();
    }

    @GetMapping("/animes/{animeId}")
    public ResponseEntity<AnimeResponse> getAnimeDetails(
            @PathVariable Long animeId) {

        Optional<Anime> foundAnime = service.getAnimeDetails(animeId);
        return foundAnime
                .map(anime -> {
                    return new ResponseEntity(animeResponseMapper.toResponse(anime), HttpStatus.OK) ;
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/animes/page")
    public Page<AnimeResponse> listsAnime(Pageable pageable) {
        /*Page<BookEntity> books = service.findAll(pageable);
        return books.map(mapper::mapTo);*/
        //Page<Anime> animes = service.
        return null;
    }

    @GetMapping("/animes/genre/{genre}")
    public List<AnimeSummaryResponse> searchByGenre(
            @PathVariable String genre) {

        return service.searchByGenreName(genre)
                .stream()
                .map(summaryMapper::toResponse)
                .toList();
    }

    @GetMapping("/animes/studio/{studio}")
    public List<AnimeSummaryResponse> searchByStudio(
            @PathVariable String studio) {

        return service.searchByStudioName(studio)
                .stream()
                .map(summaryMapper::toResponse)
                .toList();
    }

    @GetMapping("/animes/seasonal")
    public List<AnimeSummaryResponse> browseSeasonalAnime(
            @RequestParam Integer year,
            @RequestParam String season) {

        //return service.browseSeasonalAnime(year, season);
        return null;
    }
}
