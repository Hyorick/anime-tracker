package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.persistence.repository.AnimeSpecification;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.adapter.persistence.repository.AnimeRepository;
import com.ekko.anime_tracker.catalog.usecase.AnimeCatalogQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
class AnimeCatalogQueryServiceImpl implements AnimeCatalogQueryService {
    private final AnimeRepository animeRepository;

    public AnimeCatalogQueryServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public Page<Anime> search(String title, String genre, String studio, Pageable pageable) {
        return animeRepository.findAll(
                AnimeSpecification.filter(title, genre, studio),
                pageable
        );
    }

    @Override
    public Optional<Anime> getAnimeDetails(Long animeId) {
        return animeRepository.findById(animeId);
    }

    @Override
    public List<Anime> searchByGenreName(String genre) {
        return animeRepository.findByGenreName(genre);
    }

    @Override
    public List<Anime> searchByStudioName(String studio) {
        return animeRepository.findByStudioName(studio);
    }

    @Override
    public List<AnimeSummaryResponse> browseSeasonalAnime(Integer year, String season) {
        return List.of();
    }

    @Override
    public List<Anime> getAllAnimes() {
        return animeRepository.findAll();
    }

    @Override
    public Page<Anime> getAllAnimes(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

//  public List<Anime> browseSeasonal(...) {}
}
