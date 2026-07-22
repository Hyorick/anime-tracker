package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.SeasonResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                SeasonResponseMapper.class
        }
)
public interface AnimeResponseMapper
        extends ResponseMapper<Anime, AnimeResponse> {
}
