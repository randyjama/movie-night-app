package com.movienight.controllers;

import com.movienight.dataTransferObjects.MovieDiscoverResponse;
import com.movienight.dataTransferObjects.MovieSearchResponse;
import com.movienight.services.TmdbService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final TmdbService tmdbService;

    public MovieController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieSearchResponse> searchMovies(@RequestParam String query) {
        return tmdbService.searchMovies(query);
    }

    @GetMapping(value = "/discover", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieDiscoverResponse> discoverMovies(@RequestParam Map<String, String> queryParams) {
        return tmdbService.discoverMovies(queryParams);
    }

}
