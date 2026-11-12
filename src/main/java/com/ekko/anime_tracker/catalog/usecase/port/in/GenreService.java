package com.ekko.anime_tracker.catalog.usecase.port.in;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import java.util.List;

public interface GenreService {

  List<GenreEntity> resolveGenres(List<String> names);
}
