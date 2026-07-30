package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "episodes")
public class EpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_seq")
    @SequenceGenerator(
            name = "episode_seq",
            sequenceName = "episode_id_seq",
            allocationSize = 1
    )
    private Long id;

    private Integer episodeNumber;

    @Column(nullable = false)
    private String title;

    private Integer duration;

    private LocalDate airDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    private SeasonEntity season;

    public EpisodeEntity() {
    }

    // Getters & Setters
}
