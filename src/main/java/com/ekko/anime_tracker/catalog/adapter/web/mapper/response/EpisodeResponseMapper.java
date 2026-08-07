package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

import com.ekko.anime_tracker.catalog.adapter.web.response.EpisodeResponse;
import com.ekko.anime_tracker.catalog.domain.Episode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpisodeResponseMapper extends ResponseMapper<Episode, EpisodeResponse> {}
