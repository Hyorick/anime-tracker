package com.ekko.anime_tracker.library.domain;

import java.time.Instant;
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
public class UserSeason {

  @EqualsAndHashCode.Include private Long id;
  private Long userAnimeId;
  private Long seasonId;
  // private Season season;
  private WatchStatus status;
  private Integer currentEpisode;
  private Instant startedAt;
  private LocalDate finishedAt;
  private Integer personalScore;
}
