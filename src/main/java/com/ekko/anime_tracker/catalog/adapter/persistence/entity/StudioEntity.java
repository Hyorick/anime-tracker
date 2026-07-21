package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "studios")
public class StudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studio_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public StudioEntity() {
    }

    // Getters & Setters
}
