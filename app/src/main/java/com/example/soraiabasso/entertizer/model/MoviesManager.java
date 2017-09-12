package com.example.soraiabasso.entertizer.model;

import java.util.LinkedList;

/**
 * Created by soraiabasso on 12-09-2017.
 */

public enum MoviesManager {
    INSTANCE;

    private LinkedList<Movie> movies;

    MoviesManager(){
        movies = new LinkedList<>();

        addExampleMovies();
    }

    //adiciona contactos exemplo para mostrar
    private void addExampleMovies() {
        movies.add(new Movie("As Viagens de Gulliver", MovieType.FANTASIA));
        movies.add(new Movie("O Senhor dos Aneis", MovieType.FANTASIA));
        movies.add(new Movie("O Tigre e o Dragao", MovieType.ARTESMARCIAIS));
        movies.add(new Movie("2001: uma Odisseia no Espaço", MovieType.FICCAO));
    }

    //metodo para adicionar filme a parte do tipo de filme esta hardcoded porque tenho que tratar do spinner 1o
    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public LinkedList<Movie> getMovies(){
        return movies;
    }
}
