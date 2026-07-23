package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.EpisodeEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.SeasonEntity;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = EpisodeEntityAppMapper.class)
public interface SeasonEntityAppMapper
        extends AppMapper<Season, SeasonEntity> {

    @AfterMapping
    default void linkEpisodes(@MappingTarget SeasonEntity season) {

        if (season.getEpisodes() == null) {
            return;
        }

        season.getEpisodes()
                .forEach(ep -> ep.setSeason(season));
    }

    @AfterMapping
    default void fixRelationships(@MappingTarget SeasonEntity season) {

        List<EpisodeEntity> episodes = new ArrayList<>(season.getEpisodes());

        season.getEpisodes().clear();

        episodes.forEach(season::addEpisode);
    }
}
