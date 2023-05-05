package com.example.MovieService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieStorage {
    private List<Movie> movies = new ArrayList<>();

    public MovieStorage() {
        movies.add(new Movie("12345", "The Movie", Category.DOCUMENTARY));
        movies.add(new Movie("23456", "The Movie 2", Category.COMEDY));
        movies.add(new Movie("34567", "The Movie 3", Category.THRILLER));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
