package com.example.soraiabasso.entertizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.soraiabasso.entertizer.model.movies.Movie;
import com.example.soraiabasso.entertizer.model.movies.MovieType;
import com.example.soraiabasso.entertizer.model.Manager;
import com.example.soraiabasso.entertizer.model.movies.MoviesAdapter;

import java.util.LinkedList;
import java.util.List;

import static android.R.attr.order;

public class MoviesActivity extends AppCompatActivity {

    private static final int ADD_MOVIE = 1;
    private static final int EDIT_MOVIE = 2;
    private ListView listViewMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        
        initialize();
        updateListViewMovies();
    }

    //fazer ligaçao entre o menu com botao para adicionar filme e a actividade movies
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //o objecto inflate permite ir buscar o menu e dizer que pertence a esta actividade
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_movie, menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //verificamos qual foi a opçao clicada no menu
        if(item.getItemId() == R.id.btnAddMovie){

            Intent intent = new Intent(this, MovieEditActivity.class);

            startActivityForResult(intent, ADD_MOVIE);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //metodo para onde volta apos ser adicionado o filme
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_MOVIE && resultCode == RESULT_OK){
            updateListViewMovies();
        }
    }

    private void updateListViewMovies() {

        LinkedList<Movie> movies = new LinkedList<>();

        for(Movie m : Manager.INSTANCE.getMovies()){
            movies.add(m);
        }
        /*
       ArrayAdapter<Movie> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, movies);*/

        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        listViewMovies.setAdapter(adapter);
    }

    public void initialize(){

        listViewMovies = (ListView)findViewById(R.id.listViewMovies);

        listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movie movie = (Movie) parent.getItemAtPosition(position);
                Intent intent = new Intent(MoviesActivity.this, MovieEditActivity.class);

                intent.putExtra(MovieEditActivity.MOVIE_PARAM, position);
                intent.putExtra(MovieEditActivity.MOVIE_ORDER, order);

                startActivityForResult(intent, EDIT_MOVIE);
            }
        });

    }



}
