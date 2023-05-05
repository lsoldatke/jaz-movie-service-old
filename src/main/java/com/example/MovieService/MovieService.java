package com.example.MovieService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieStorage movieStorage;

    public MovieService(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    public List<Movie> getAllMovies() {
        return movieStorage.getMovies();
    }
}
