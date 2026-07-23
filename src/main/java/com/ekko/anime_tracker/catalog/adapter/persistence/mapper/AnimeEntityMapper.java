package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.SeasonEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
         uses = {
        SeasonEntityAppMapper.class,
        GenreEntityMapper.class,
        StudioEntityMapper.class
})
public interface AnimeEntityMapper extends AppMapper<Anime, AnimeEntity> {

    @AfterMapping
    default void linkSeasons(@MappingTarget AnimeEntity anime) {

        if (anime.getSeasons() == null) {
            return;
        }

        anime.getSeasons()
                .forEach(season -> season.setAnime(anime));
    }

    @AfterMapping
    default void fixRelationships(@MappingTarget AnimeEntity anime) {

        List<SeasonEntity> seasons = new ArrayList<>(anime.getSeasons());

        anime.getSeasons().clear();

        seasons.forEach(anime::addSeason);
    }
}
