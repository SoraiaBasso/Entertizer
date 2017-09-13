package com.example.soraiabasso.entertizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soraiabasso.entertizer.model.Manager;
import com.example.soraiabasso.entertizer.model.movies.Movie;
import com.example.soraiabasso.entertizer.model.movies.MovieType;

public class MovieEditActivity extends AppCompatActivity {

    public static final String MOVIE_PARAM = "Posicao do filme a editar";
    public static final String MOVIE_ORDER = "ordem do filme a editar";
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_edit);

        editTextName = (EditText) findViewById(R.id.editTextMovieName);
    }

    public void onClickButtonAccept(View view) {

        String name = editTextName.getText().toString();

        if(!name.isEmpty()){

            Movie movie = new Movie(name, MovieType.ARTESMARCIAIS);

            Manager.INSTANCE.addMovie(movie);

            //voltar ao ecra anterior e actualizar a lista de filmes
            setResult(RESULT_OK);
            finish();

        } else {
            Toast.makeText(this, "Tem que inserir o nome do filme!", Toast.LENGTH_LONG).show();
        }

    }

}
