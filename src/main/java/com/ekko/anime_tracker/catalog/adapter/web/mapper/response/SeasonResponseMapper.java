package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

import com.ekko.anime_tracker.catalog.adapter.web.response.SeasonResponse;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {EpisodeResponseMapper.class})
public interface SeasonResponseMapper extends ResponseMapper<Season, SeasonResponse> {}
