package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SeasonEntityAppMapper.class)
public interface AnimeEntityMapper
        extends AppMapper<Anime, AnimeEntity> {
}
