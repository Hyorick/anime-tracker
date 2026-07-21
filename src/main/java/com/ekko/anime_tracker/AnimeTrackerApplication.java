package com.ekko.anime_tracker;

import com.ekko.anime_tracker.catalog.domain.Anime;
import com.ekko.anime_tracker.catalog.domain.Season;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimeTrackerApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnimeTrackerApplication.class, args);
	}

}
