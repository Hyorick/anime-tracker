package com.ekko.anime_tracker.catalog.usecase.port.in;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;

public interface StudioService {

  StudioEntity resolveStudio(String name);
}
