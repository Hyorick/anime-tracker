package com.ekko.anime_tracker.catalog.adapter.web.mapper.response;

public interface ResponseMapper<D, R> {

    R toResponse(D domain);

}
