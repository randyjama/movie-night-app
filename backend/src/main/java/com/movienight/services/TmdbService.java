package com.movienight.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;


@Service
public class TmdbService {
    private final WebClient webClient;

    @Value("${tmdb.api.key}")
    private String apiKey;

    // inject tmdb api config bean
    public TmdbService(WebClient tmdbWebClient) {
        this.webClient = tmdbWebClient;
    }

    public Mono<String> searchMovies(String query) {
        String uri = UriComponentsBuilder.fromPath("/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .build()
                .toUriString();

        return webClient.get().uri(uri).retrieve().bodyToMono(String.class);
    }
}
