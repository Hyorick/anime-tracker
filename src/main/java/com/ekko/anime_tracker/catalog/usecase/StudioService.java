package com.ekko.anime_tracker.catalog.usecase;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;

public interface StudioService {

    StudioEntity resolveStudio(String name);

}
