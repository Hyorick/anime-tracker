package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateAnimeRequest;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.Genre;
import com.ekko.anime_tracker.catalog.domain.Studio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SeasonRequestMapper.class)
public interface AnimeRequestMapper
        extends RequestMapper<Anime, CreateAnimeRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    Anime toDomain(CreateAnimeRequest request);

    default Genre map(String genre) {
        Genre g = new Genre();
        g.setName(genre);
        return g;
    }

    default Studio mapStudio(String studio) {
        Studio s = new Studio();
        s.setName(studio);
        return s;
    }
}
