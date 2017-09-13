package com.example.soraiabasso.entertizer.model.movies;

/**
 * Created by soraiabasso on 12-09-2017.
 */

public class Movie {

    private String movieName;
    private Enum movieType;

    public Movie(String movieName, Enum movieType) {
        this.movieName = movieName;
        this.movieType = movieType;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    //isto nao deveria ser diferente? tipo devolver uma string com o genero em vex de uma enumeraçao?
    public Enum getMovieType() {
        return movieType;
    }

    public void setMovieType(Enum movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return  movieName + "      " + movieType;
    }
}
