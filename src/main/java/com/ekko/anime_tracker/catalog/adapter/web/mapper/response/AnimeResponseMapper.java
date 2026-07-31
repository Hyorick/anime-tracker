package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

import com.ekko.anime_tracker.catalog.adapter.web.mapper.request.SeasonResponseMapper;
import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                SeasonResponseMapper.class
        }
)
public interface AnimeResponseMapper extends ResponseMapper<Anime, AnimeResponse> {

        @Mapping(target = "studio", source = "studio.name")
        AnimeResponse toResponse(Anime anime);

        default String map(Genre genre) {
                return genre.getName();
        }
}
