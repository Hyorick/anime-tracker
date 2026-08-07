package com.ekko.anime_tracker.catalog.adapter.web.mapper.request;

public interface RequestMapper<D, R> {

  D toDomain(R request);
}
