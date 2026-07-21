package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public GenreEntity() {
    }

    // Getters & Setters
}
