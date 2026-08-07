package com.ekko.anime_tracker.catalog.adapter.persistence.mapper;

public interface AppMapper<D, E> {

  D toDomain(E entity);

  E toEntity(D domain);
}
