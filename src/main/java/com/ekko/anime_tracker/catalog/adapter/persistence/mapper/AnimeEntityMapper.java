package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

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

}
