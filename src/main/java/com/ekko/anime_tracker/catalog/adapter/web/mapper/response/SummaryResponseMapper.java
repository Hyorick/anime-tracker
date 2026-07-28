package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

import com.ekko.anime_tracker.catalog.adapter.web.response.AnimeSummaryResponse;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SummaryResponseMapper extends ResponseMapper<Anime, AnimeSummaryResponse> {
    @Mapping(target = "studio", source = "studio.name")
    @Mapping(target = "seasonCount", expression = "java(getSeasonCount(anime))")
    @Mapping(target = "episodeCount", expression = "java(getEpisodeCount(anime))")
    AnimeSummaryResponse toResponse(Anime anime);

    default int getSeasonCount(Anime anime) {
        return anime.getSeasons() == null ? 0 : anime.getSeasons().size();
    }

    default int getEpisodeCount(Anime anime) {

        if (anime.getSeasons() == null) {
            return 0;
        }
        return anime.getSeasons()
                .stream()
                .mapToInt(season ->
                        season.getEpisodes() == null
                                ? 0
                                : season.getEpisodes().size())
                .sum();
    }

    default String map(Genre genre) {
        return genre.getName();
    }
}
