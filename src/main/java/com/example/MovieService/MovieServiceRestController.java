package com.example.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie.getId().equals("")) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(movie);
        }
    }
}
