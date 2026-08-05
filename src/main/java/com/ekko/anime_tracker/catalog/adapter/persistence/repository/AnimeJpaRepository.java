package com.ekko.anime_tracker.catalog.adapter.persistence.repository;

import com.ekko.anime_tracker.catalog.adapter.persistence.entity.AnimeEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.GenreEntity;
import com.ekko.anime_tracker.catalog.adapter.persistence.entity.StudioEntity;
import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.adapter.persistence.mapper.AnimeEntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class AnimeJpaRepository implements AnimeRepository {

    private final SpringDataAnimeRepository animeRepository;
    private final SpringDataGenreRepository genreRepository;
    private final SpringDataStudioRepository studioRepository;
    private final AnimeEntityMapper animeEntityMapper;

    public AnimeJpaRepository(SpringDataAnimeRepository animeRepository, SpringDataGenreRepository genreRepository, SpringDataStudioRepository studioRepository, AnimeEntityMapper animeEntityMapper) {
        this.animeRepository = animeRepository;
        this.genreRepository = genreRepository;
        this.studioRepository = studioRepository;
        this.animeEntityMapper = animeEntityMapper;
    }

    @Override
    public Anime save(Anime anime) {

        AnimeEntity dbEntitySent = animeEntityMapper.toEntity(anime);

        StudioEntity studio = studioRepository
                .findByName(anime.getStudio().getName())
                .orElseGet(() -> {
                    StudioEntity s = new StudioEntity();
                    s.setName(anime.getStudio().getName());
                    return studioRepository.save(s);
                });

        dbEntitySent.setStudio(studio);

        List<GenreEntity> genres = anime.getGenres()
                .stream()
                .map(genre ->
                        genreRepository.findByName(genre.getName())
                                .orElseGet(() -> {
                                    GenreEntity g = new GenreEntity();
                                    g.setName(genre.getName());
                                    return genreRepository.save(g);
                                }))
                .toList();

        dbEntitySent.setGenres(genres);

        AnimeEntity savedAnimeEntity = animeRepository.save(dbEntitySent);

        return animeEntityMapper.toDomain(savedAnimeEntity);
    }

    @Override
    public boolean exists(Long animeId) {
        return animeRepository.existsById(animeId);
    }

    @Override
    public Optional<Anime> findById(Long id) {
        return animeRepository.findById(id).map(animeEntityMapper::toDomain);
    }

    @Override
    public Optional<Anime> findByTitle(String title) {
        return animeRepository.findByTitle(title).map(animeEntityMapper::toDomain);
    }

    @Override
    public List<Anime> findByGenreName(String genreName) {
        return animeRepository.findByGenres_NameIgnoreCase(genreName)
                .stream()
                .map(animeEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anime> findByStudioName(String studioName) {
        return animeRepository.findByStudio_NameIgnoreCase(studioName)
                .stream()
                .map(animeEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anime> findAll() {
        return animeRepository.findAll()
                .stream()
                .map(animeEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Page<Anime> findAll(Pageable pageable) {
        return animeRepository.findAll(pageable)
                .map(animeEntityMapper::toDomain);
    }

    @Override
    public Page<Anime> findAll(Specification<AnimeEntity> specification, Pageable pageable) {
        return animeRepository.findAll(specification, pageable)
                .map(animeEntityMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        animeRepository.deleteById(id);
    }

    @Override
    public void delete(Anime anime) {
        animeRepository.delete(animeEntityMapper.toEntity(anime));
    }
}
