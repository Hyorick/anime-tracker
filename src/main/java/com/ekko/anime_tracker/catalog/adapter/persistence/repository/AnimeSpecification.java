package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class AnimeSpecification {

    public static Specification<AnimeEntity> filter(
            String title,
            String genre,
            String studio) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (title != null && !title.isBlank()) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("title")),
                                "%" + title.toLowerCase() + "%"
                        )
                );
            }

            if (studio != null && !studio.isBlank()) {
                Join<AnimeEntity, StudioEntity> studioJoin = root.join("studio");
                predicates.add(
                        cb.equal(
                                cb.lower(studioJoin.get("name")),
                                studio.toLowerCase()
                        )
                );
            }

            if (genre != null && !genre.isBlank()) {
                Join<AnimeEntity, GenreEntity> genres = root.join("genres");
                predicates.add(
                        cb.equal(
                                cb.lower(genres.get("name")),
                                genre.toLowerCase()
                        )
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
