package com.twu.biblioteca;

public class Movie {

    private String id;
    private String name;
    private String year;
    private String director;
    private String movieRating;

    public Movie() {}

    public Movie(String id, String name, String year, String director, String movieRating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieDetail(Movie movie) {
        return String.format("%s\t%s\t%s\t%s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getMovieRating());
    }

    public String getId() {
        return id;
    }
}
