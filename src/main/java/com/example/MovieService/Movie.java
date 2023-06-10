package com.example.MovieService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Movie ID", example = "12345")
    private Long id;
    @Schema(description = "Movie name", example = "The Movie")
    private String name;
    @Enumerated(EnumType.STRING)
    @Schema(description = "Movie category", example = "DOCUMENTARY")
    private Category category;
    @Schema(description = "Movie availability", example = "true")
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(Long id, String name, Category category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
