package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "animes")
public class AnimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anime_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id")
    private StudioEntity studio;

    @ManyToMany
    @JoinTable(
            name = "anime_genre",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres = new ArrayList<>();

    @OneToMany(
            mappedBy = "anime",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SeasonEntity> seasons = new ArrayList<>();

    public AnimeEntity() {
    }

    // Getters & Setters
    public void addSeason(SeasonEntity season) {

        seasons.add(season);

        season.setAnime(this);
    }

    public void removeSeason(SeasonEntity season) {

        seasons.remove(season);

        season.setAnime(null);
    }
}
