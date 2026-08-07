package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import com.ekko.anime_tracker.catalog.domain.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreEntityMapper extends AppMapper<Genre, GenreEntity> {}
