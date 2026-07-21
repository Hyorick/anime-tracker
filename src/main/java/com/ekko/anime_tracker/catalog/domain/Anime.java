package com.ekko.anime_tracker.catalog.domain;

import java.time.LocalDate;
import java.util.List;

import com.ekko.anime_tracker.catalog.domain.enums.AnimeStatus;
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
public class Anime {

    @EqualsAndHashCode.Include
    private Long id;
    private String title;// doit etre unique
    private String synopsis;
    private LocalDate releaseYear;
    // private AnimeStatus status;  airing
    private Studio studio;
    private List<Genre> genres;
    private List<Season> seasons;
}