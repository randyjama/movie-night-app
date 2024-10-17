package com.movienight.dataTransferObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movienight.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
@Setter
public class MovieSearchResponse {
    private int page;
    private List<Movie> results;
}

