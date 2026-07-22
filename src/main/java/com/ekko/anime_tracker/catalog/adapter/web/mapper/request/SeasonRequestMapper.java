package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateSeasonRequest;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EpisodeRequestMapper.class
        }
)
public interface SeasonRequestMapper
        extends RequestMapper<Season, CreateSeasonRequest> {
}
