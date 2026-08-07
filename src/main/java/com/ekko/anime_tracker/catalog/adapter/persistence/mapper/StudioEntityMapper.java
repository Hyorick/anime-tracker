package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;
import com.ekko.anime_tracker.catalog.domain.Studio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudioEntityMapper extends AppMapper<Studio, StudioEntity> {}
