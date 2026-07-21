package com.ekko.anime_tracker.catalog.domain;

import java.time.LocalDate;
import java.util.List;

import com.ekko.anime_tracker.catalog.domain.enums.SeasonStatus;
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
public class Season {

    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Include
    private Long animeId;

    @EqualsAndHashCode.Include
    private Integer seasonNumber;

    // private SeasonStatus status; airing
    @EqualsAndHashCode.Include
    private String title; // doit être unique

    private String description;
    private LocalDate releaseDate;
    private List<Episode> episodes;
}