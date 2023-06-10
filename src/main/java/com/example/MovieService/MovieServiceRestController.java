package com.example.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieservice")
public class MovieServiceRestController {
    private final MovieService movieService;

    public MovieServiceRestController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @Operation(summary = "Get movie by ID", description = "Returns movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - Movie was not found")
    })
    @GetMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> returnMovie(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movie);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie.getId() == null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(movie);
        }
    }

    @PutMapping("/movies/return/{id}")
    public ResponseEntity<Optional<Movie>> changeAvailabilityToTrue(@PathVariable Long id) {
        Optional<Movie> movie = movieService.setAvailability(id, true);
        return ResponseEntity.ok(movie);
    }
}
