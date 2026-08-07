package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

import com.ekko.anime_tracker.catalog.adapter.web.request.CreateSeasonRequest;
import com.ekko.anime_tracker.catalog.adapter.web.request.PatchSeasonRequest;
import com.ekko.anime_tracker.catalog.adapter.web.request.UpdateSeasonRequest;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    uses = {EpisodeRequestMapper.class})
public interface SeasonRequestMapper extends RequestMapper<Season, CreateSeasonRequest> {

  @Override
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "animeId", ignore = true)
  Season toDomain(CreateSeasonRequest request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "animeId", ignore = true)
  void updateSeason(UpdateSeasonRequest request, @MappingTarget Season season);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "animeId", ignore = true)
  @Mapping(target = "episodes", ignore = true)
  void patchSeason(PatchSeasonRequest request, @MappingTarget Season season);
}
