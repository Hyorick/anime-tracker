package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateEpisodeRequest;
import com.ekko.anime_tracker.catalog.domain.Episode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpisodeRequestMapper
        extends RequestMapper<Episode, CreateEpisodeRequest> {
}
