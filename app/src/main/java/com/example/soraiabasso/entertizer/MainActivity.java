package com.example.soraiabasso.entertizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    //metodo para mudar da MainActivity para a MoviesA  ctivity quando o botao for clicado
    public void onClickButtonMovies(View view) {
        startActivity(new Intent(MainActivity.this, MoviesActivity.class));
    }

}
