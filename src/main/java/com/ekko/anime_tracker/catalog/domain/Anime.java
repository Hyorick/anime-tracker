package com.ekko.anime_tracker.catalog.domain;

import java.time.LocalDate;
import java.util.List;

import com.ekko.anime_tracker.catalog.domain.enums.AnimeStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
public class Anime {

    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Include
    private String title;// doit etre unique

    private String synopsis;
    //private LocalDate releaseYear;
    private Integer releaseYear;
    // private AnimeStatus status;  airing
    private Studio studio;
    private List<Genre> genres;
    private List<Season> seasons;
}