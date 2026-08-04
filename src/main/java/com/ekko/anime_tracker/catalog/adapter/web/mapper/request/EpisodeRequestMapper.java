package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateEpisodeRequest;
import com.ekko.anime_tracker.catalog.adapter.web.request.UpdateEpisodeRequest;
import com.ekko.anime_tracker.catalog.domain.Episode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EpisodeRequestMapper extends RequestMapper<Episode, CreateEpisodeRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    Episode toDomain(CreateEpisodeRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "episodeNumber", ignore = true)
    void updateEpisode(UpdateEpisodeRequest request, @MappingTarget Episode episode);

}
