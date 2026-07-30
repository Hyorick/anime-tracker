package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "genres",
    uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_genres_name",
                columnNames = "name"
        )
    }
)
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(
            name = "genre_seq",
            sequenceName = "genre_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public GenreEntity() {
    }

    // Getters & Setters
}
