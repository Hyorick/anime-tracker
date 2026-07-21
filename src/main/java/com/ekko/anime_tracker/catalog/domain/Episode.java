package com.ekko.anime_tracker.catalog.domain;

import java.time.LocalDate;
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
public class Episode {

    @EqualsAndHashCode.Include
    private Long seasonId;
    private Integer episodeNumber;
    private String title; //doit être unique
    private Integer duration; // minutes
    private LocalDate airDate;
}