package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateAnimeRequest;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SeasonRequestMapper.class)
public interface AnimeRequestMapper
        extends RequestMapper<Anime, CreateAnimeRequest> {
}
