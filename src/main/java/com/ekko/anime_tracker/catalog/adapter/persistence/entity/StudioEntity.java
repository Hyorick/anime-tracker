package com.ekko.anime_tracker.catalog.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "studios",
    uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_studios_name",
                columnNames = "name"
        )
    }
)
public class StudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studio_seq")
    @SequenceGenerator(
            name = "studio_seq",
            sequenceName = "studio_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public StudioEntity() {
    }

    // Getters & Setters
}
