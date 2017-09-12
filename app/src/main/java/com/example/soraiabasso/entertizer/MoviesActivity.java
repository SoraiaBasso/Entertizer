package com.example.soraiabasso.entertizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.soraiabasso.entertizer.model.Movie;
import com.example.soraiabasso.entertizer.model.MovieType;
import com.example.soraiabasso.entertizer.model.MoviesManager;

import java.util.LinkedList;

public class MoviesActivity extends AppCompatActivity {

    private ListView listViewMovies;
    private EditText editTextMovieName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        editTextMovieName = (EditText) findViewById(R.id.editTextName);

        listViewMovies = (ListView)findViewById(R.id.listViewMovies);
        updateListViewMovies();
    }

    private void updateListViewMovies() {

        LinkedList<Movie> movies = new LinkedList<>();

        for(Movie m : MoviesManager.INSTANCE.getMovies()){
            movies.add(m);
        }
        //adaptador usando ArrayAdaptar
        //TODO
        //criar um adaptador especifico
       ArrayAdapter<Movie> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, movies);
        listViewMovies.setAdapter(adapter);
    }

    public void onClickButtonMovieAdd(View view) {
        String name = editTextMovieName.getText().toString();
        // ir buscar o estilo seleccionado no spinner

        if(!name.isEmpty()){

                //TODO
                //ir buscar o genero ao spinner
                Movie movie = new Movie(name, MovieType.ARTESMARCIAIS);

                MoviesManager.INSTANCE.addMovie(movie);

        } else{
            Toast.makeText(this, "Tem que inserir o nome do filme!", Toast.LENGTH_LONG).show();
        }
        updateListViewMovies();
    }
}
