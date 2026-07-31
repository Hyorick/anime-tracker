package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.EpisodeEntity;
import com.ekko.anime_tracker.catalog.domain.Episode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpisodeEntityAppMapper extends AppMapper<Episode, EpisodeEntity> {
}
