package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.mapper.OrderMapper;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimeJpaRepository implements AnimeRepository {

    private final SpringDataAnimeRepository repository;
    private final OrderMapper mapper;

    public AnimeJpaRepository(SpringDataAnimeRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void /*Anime*/ save(Anime anime) {
        repository.save(mapper.toEntity(anime));
        //return null;
    }

    @Override
    public Optional<Anime> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Anime> findByTitle(String title) {

        return repository.findByTitle(title).map(mapper::toDomain);
    }

    @Override
    public List<Anime> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Anime anime) {
        repository.delete(mapper.toEntity(anime));
    }
}
