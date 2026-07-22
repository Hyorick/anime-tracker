package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.AnimeRepository;
import com.ekko.anime_tracker.catalog.adapter.persistence.mapper.AnimeEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimeJpaRepository implements AnimeRepository {

    private final SpringDataAnimeRepository repository;
    private final AnimeEntityMapper animeEntityMapper;

    public AnimeJpaRepository(SpringDataAnimeRepository repository, AnimeEntityMapper animeEntityMapper) {
        this.repository = repository;
        this.animeEntityMapper = animeEntityMapper;
    }

    @Override
    public Anime save(Anime anime) {
        AnimeEntity animeEntity = repository.save(animeEntityMapper.toEntity(anime));
        return animeEntityMapper.toDomain(animeEntity);
        //return null;
    }

    @Override
    public Optional<Anime> findById(Long id) {
        return repository.findById(id).map(animeEntityMapper::toDomain);
    }

    @Override
    public Optional<Anime> findByTitle(String title) {

        return repository.findByTitle(title).map(animeEntityMapper::toDomain);
    }

    @Override
    public List<Anime> findAll() {
        return repository.findAll()
                .stream()
                .map(animeEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Anime anime) {
        repository.delete(animeEntityMapper.toEntity(anime));
    }
}
