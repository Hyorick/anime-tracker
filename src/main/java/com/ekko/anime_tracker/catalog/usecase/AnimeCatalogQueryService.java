package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimeCatalogQueryService {

  Page<Anime> search(String title, String genre, String studio, Pageable pageable);

  Optional<Anime> getAnimeDetails(Long animeId);

  List<Anime> searchByGenreName(String genre);

  List<Anime> searchByStudioName(String studio);

  List<AnimeSummaryResponse> browseSeasonalAnime(Integer year, String season);

  List<Anime> getAllAnimes();

  Page<Anime> getAllAnimes(Pageable pageable);
}
