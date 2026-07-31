package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.repository.SpringDataGenreRepository;
import com.ekko.anime_tracker.catalog.usecase.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GenreServiceImpl implements GenreService {
    private final SpringDataGenreRepository repository;

    public GenreServiceImpl(SpringDataGenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GenreEntity> resolveGenres(List<String> names) {

        return names.stream()
                .map(name ->
                        repository.findByName(name)
                                .orElseGet(() -> {
                                    GenreEntity genre = new GenreEntity();
                                    genre.setName(name);
                                    return repository.save(genre);
                                }))
                .toList();
    }
}
