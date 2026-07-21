package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_id_seq")
    private Long id;

    private Integer seasonNumber;

    private String title;

    private String description;

    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", nullable = false)
    private AnimeEntity anime;

    @OneToMany(
            mappedBy = "season",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EpisodeEntity> episodes = new ArrayList<>();

    public SeasonEntity() {
    }

    // Getters & Setters
}
