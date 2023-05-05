package com.example.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieservice")
public class MovieServiceRestController {
    private MovieService movieService;

    public MovieServiceRestController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
