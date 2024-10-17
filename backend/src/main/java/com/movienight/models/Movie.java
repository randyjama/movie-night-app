package com.movienight.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private int id;
    private String title;
    private String overview;
    private double vote_average;
    private int vote_count;
    private String release_date;
    private String poster_path;
    private String backdrop_path;
}
