package com.example.soraiabasso.entertizer.model.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.soraiabasso.entertizer.R;

import java.util.List;

/**
 * This is My MovieAdapter to be used in ListViews
 * Created by soraiabasso on 13-09-2017.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, List<Movie> objects) {
        super(context, R.layout.item_movie, R.id.textViewMovieName, objects);
    }


    //TODO DUVIDA
    //o que raio e isto do nonnull?
   @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        Movie movie = getItem(position);

        ViewHolder holder = (ViewHolder) v.getTag();

        if(holder==null){
            holder = new ViewHolder(v);
            v.setTag(holder);
        }
        holder.updateView(movie);
        return v;

    }


    //classe estatica que nao sei pk e estatica mas pronto
    static class ViewHolder {
        public TextView textViewMvName;
        public TextView textViewMvType;

        //construtor desta classe estatica
        public ViewHolder(View v){
            textViewMvName = (TextView) v.findViewById(R.id.textViewMovieName);
            textViewMvType = (TextView) v.findViewById(R.id.textViewType);
        }

        //metodo para actualizar a vista do item
        public void updateView(Movie movie) {
            textViewMvName.setText(movie.getMovieName());
            textViewMvType.setText(movie.getMovieType().toString());
        }

    }


}
