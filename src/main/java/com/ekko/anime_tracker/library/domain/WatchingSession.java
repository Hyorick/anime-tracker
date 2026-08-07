package com.ekko.anime_tracker.library.domain;

import com.ekko.anime_tracker.catalog.domain.Episode;
import com.ekko.anime_tracker.catalog.domain.Season;
import java.time.LocalDateTime;
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
public class WatchingSession {

  @EqualsAndHashCode.Include private Season season;
  private Episode episode;
  private LocalDateTime watchedAt;
  private Integer duration;
}
