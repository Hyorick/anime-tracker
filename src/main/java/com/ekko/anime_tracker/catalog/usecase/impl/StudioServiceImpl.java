package com.ekko.anime_tracker.catalog.usecase.impl;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.repository.SpringDataStudioRepository;
import com.ekko.anime_tracker.catalog.usecase.StudioService;
import org.springframework.stereotype.Service;

@Service
class StudioServiceImpl implements StudioService {

  private final SpringDataStudioRepository repository;

  public StudioServiceImpl(SpringDataStudioRepository repository) {
    this.repository = repository;
  }

  @Override
  public StudioEntity resolveStudio(String name) {

    return repository
        .findByName(name)
        .orElseGet(
            () -> {
              StudioEntity studio = new StudioEntity();
              studio.setName(name);
              return repository.save(studio);
            });
  }
}
