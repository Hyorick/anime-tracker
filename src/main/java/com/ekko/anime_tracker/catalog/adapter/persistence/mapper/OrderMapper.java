package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Anime toDomain(AnimeEntity entity);

    AnimeEntity toEntity(Anime anime);

}
