package com.movienight.services;

import com.movienight.dataTransferObjects.MovieDiscoverResponse;
import com.movienight.dataTransferObjects.MovieSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Set;


@Service
public class TmdbService {
    private final WebClient webClient;

    @Value("${tmdb.api.key}")
    private String apiKey;

    // inject tmdb api config bean
    public TmdbService(WebClient tmdbWebClient) {
        this.webClient = tmdbWebClient;
    }

    public Mono<MovieSearchResponse> searchMovies(String query) {
        String uri = UriComponentsBuilder.fromPath("/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .build()
                .toUriString();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .onStatus(
                        status -> status.isError(),
                        clientResponse -> clientResponse.createException()
                )
                .bodyToMono(MovieSearchResponse.class);
    }

    public Mono<MovieDiscoverResponse> discoverMovies(Map<String, String> queryParams) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath("/discover/movie").queryParam("api_key", apiKey);

        Set<String> allowedParams = Set.of(
                "sort_by", "vote_count.gte", "vote_average.gte", "vote_average.lte",
                "primary_release_date.gte", "primary_release_date.lte",
                "with_genres", "with_runtime.gte", "with_runtime.lte",
                "page", "language", "region"
        );

        queryParams.entrySet().stream()
                .filter(entry -> allowedParams.contains(entry.getKey()))
                .forEach(entry -> uriBuilder.queryParam(entry.getKey(), entry.getValue()));

        String uri = uriBuilder.build().toUriString();

        return webClient.get().uri(uri).retrieve().onStatus(
                    status -> status.isError(),
                    clientResponse -> clientResponse.createException()
                )
                .bodyToMono(MovieDiscoverResponse.class);
    }

}
