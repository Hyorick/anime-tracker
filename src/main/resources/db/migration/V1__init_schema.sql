-- Sequences
CREATE SEQUENCE anime_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE season_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE episode_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE genre_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE studio_id_seq START WITH 1 INCREMENT BY 1;

-- Studios
CREATE TABLE studios (
    id BIGINT PRIMARY KEY DEFAULT nextval('studio_id_seq'),
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Genres
CREATE TABLE genres (
    id BIGINT PRIMARY KEY DEFAULT nextval('genre_id_seq'),
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Animes
CREATE TABLE animes (
    id BIGINT PRIMARY KEY DEFAULT nextval('anime_id_seq'),
    title VARCHAR(255) NOT NULL UNIQUE,
    synopsis TEXT,
    release_date DATE,
    studio_id BIGINT,
    CONSTRAINT fk_anime_studio
        FOREIGN KEY (studio_id)
            REFERENCES studios(id)
);

-- Seasons
CREATE TABLE seasons (
    id BIGINT PRIMARY KEY DEFAULT nextval('season_id_seq'),
    season_number INTEGER,
    title VARCHAR(255),
    description VARCHAR(255),
    release_date DATE,
    anime_id BIGINT NOT NULL,
    CONSTRAINT fk_season_anime
        FOREIGN KEY (anime_id)
            REFERENCES animes(id)
            ON DELETE CASCADE
);

-- Episodes
CREATE TABLE episodes (
    id BIGINT PRIMARY KEY DEFAULT nextval('episode_id_seq'),
    episode_number INTEGER,
    title VARCHAR(255) NOT NULL,
    duration INTEGER,
    air_date DATE,
    season_id BIGINT NOT NULL,
    CONSTRAINT fk_episode_season
        FOREIGN KEY (season_id)
            REFERENCES seasons(id)
            ON DELETE CASCADE
);

-- Many-to-Many Join Table
CREATE TABLE anime_genre (
    anime_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (anime_id, genre_id),
    CONSTRAINT fk_anime_genre_anime
        FOREIGN KEY (anime_id)
            REFERENCES animes(id)
            ON DELETE CASCADE,
    CONSTRAINT fk_anime_genre_genre
        FOREIGN KEY (genre_id)
            REFERENCES genres(id)
            ON DELETE CASCADE
);