package com.example.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable String id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movie);
        }
    }
}
