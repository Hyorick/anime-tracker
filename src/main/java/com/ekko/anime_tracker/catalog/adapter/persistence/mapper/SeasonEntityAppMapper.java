package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.SeasonEntity;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EpisodeEntityAppMapper.class)
public interface SeasonEntityAppMapper
        extends AppMapper<Season, SeasonEntity> {
}
