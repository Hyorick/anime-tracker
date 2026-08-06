package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateEpisodeRequest;
import com.ekko.anime_tracker.catalog.adapter.web.request.PatchEpisodeRequest;
import com.ekko.anime_tracker.catalog.adapter.web.request.UpdateEpisodeRequest;
import com.ekko.anime_tracker.catalog.domain.Episode;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EpisodeRequestMapper extends RequestMapper<Episode, CreateEpisodeRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    Episode toDomain(CreateEpisodeRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    void updateEpisode(UpdateEpisodeRequest request, @MappingTarget Episode episode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    void patchEpisode(PatchEpisodeRequest request, @MappingTarget Episode episode);

}
