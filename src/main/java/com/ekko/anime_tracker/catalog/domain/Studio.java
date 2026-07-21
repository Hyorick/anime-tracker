package com.ekko.anime_tracker.catalog.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Studio {

    @EqualsAndHashCode.Include
    private Long id;
    private String name; //doit etre unique
}