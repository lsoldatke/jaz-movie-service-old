package com.example.MovieService;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie() {
    }

    public Movie(String id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() {
        return id;
    }
}
