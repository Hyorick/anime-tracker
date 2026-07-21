package com.ekko.anime_tracker.library.domain;

import com.ekko.anime_tracker.catalog.domain.Anime;

import java.time.Instant;
import java.time.LocalDate;

import com.ekko.anime_tracker.catalog.domain.AnimeId;
import com.ekko.anime_tracker.identity.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class UserAnime {

    @EqualsAndHashCode.Include
    private Long id;
    private Long userId;
    private Long animeId;
    private WatchStatus overallStatus;
    private Boolean favorite;
    private Integer personalScore;
    private Instant startedAt;
    private LocalDate finishedAt;
}