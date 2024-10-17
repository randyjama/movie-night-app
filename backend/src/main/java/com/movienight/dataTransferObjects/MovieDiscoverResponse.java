package com.movienight.dataTransferObjects;

import com.movienight.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MovieDiscoverResponse {
    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;
}
