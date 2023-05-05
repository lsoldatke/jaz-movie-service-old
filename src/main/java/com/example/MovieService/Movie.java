package com.example.MovieService;

public class Movie {
    private String id;
    private String name;
    private Category category;

    public Movie(String id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() {
        return id;
    }
}
