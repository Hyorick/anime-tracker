package com.ekko.anime_tracker.catalog.adapter.web;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.AnimeResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.mapper.response.SummaryResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogQueryService;
import java.util.List;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogQueryController {

  private final AnimeCatalogQueryService service;
  private final AnimeResponseMapper animeResponseMapper;
  private final SummaryResponseMapper summaryMapper;

  public CatalogQueryController(
      AnimeCatalogQueryService service,
      AnimeResponseMapper animeResponseMapper,
      SummaryResponseMapper summaryMapper) {
    this.service = service;
    this.animeResponseMapper = animeResponseMapper;
    this.summaryMapper = summaryMapper;
  }

  @GetMapping("/animes/search")
  public Page<AnimeResponse> searchAnime(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) String genre,
      @RequestParam(required = false) String studio,
      @ParameterObject Pageable pageable) {

    Page<Anime> animes = service.search(title, genre, studio, pageable);
    return animes.map(animeResponseMapper::toResponse);
  }

  @GetMapping("/animes/{animeId}")
  public ResponseEntity<AnimeResponse> getAnimeDetails(@PathVariable Long animeId) {

    Optional<Anime> foundAnime = service.getAnimeDetails(animeId);
    return foundAnime
        .map(anime -> ResponseEntity.ok(animeResponseMapper.toResponse(anime)))
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = "/animes")
  public List<AnimeResponse> listsAnime() {

    List<Anime> animes = service.getAllAnimes();
    return animes.stream().map(animeResponseMapper::toResponse).toList();
  }

  @GetMapping(path = "/animes/page")
  public Page<AnimeResponse> listsAnime(@ParameterObject Pageable pageable) {

    Page<Anime> animes = service.getAllAnimes(pageable);
    return animes.map(animeResponseMapper::toResponse);
  }

  @GetMapping("/animes/genre/{genre}")
  public List<AnimeSummaryResponse> searchByGenre(@PathVariable String genre) {

    return service.searchByGenreName(genre).stream().map(summaryMapper::toResponse).toList();
  }

  @GetMapping("/animes/studio/{studio}")
  public List<AnimeSummaryResponse> searchByStudio(@PathVariable String studio) {

    return service.searchByStudioName(studio).stream().map(summaryMapper::toResponse).toList();
  }

  @GetMapping("/animes/seasonal")
  public List<AnimeSummaryResponse> browseSeasonalAnime(
      @RequestParam Integer year, @RequestParam String season) {

    // return service.browseSeasonalAnime(year, season);
    return null;
  }
}
