package com.example.kinopoisk.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinopoisk.R;

public class MovieViewHolger extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView title,category, movie_year;
    ImageView imageView;
    RatingBar ratingBar;
    OnMovieListener onMovieListener;


    public MovieViewHolger(@NonNull View itemView, OnMovieListener movieListener) {
        super(itemView);

        this.onMovieListener = movieListener;
        title = itemView.findViewById(R.id.movie_title);
        category = itemView.findViewById(R.id.movie_category);
        movie_year = itemView.findViewById(R.id.movie_year);

        imageView = itemView.findViewById(R.id.movie_img);
        ratingBar = itemView.findViewById(R.id.rating_bar);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
onMovieListener.onMovieClick(getAdapterPosition());
    }
}
