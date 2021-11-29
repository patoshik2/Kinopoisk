package com.example.kinopoisk.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kinopoisk.R;
import com.example.kinopoisk.models.MovieModel;

import java.util.List;

public class MovieRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   private List<MovieModel> mMovies;
   private  OnMovieListener onMovieListener;

    public MovieRecyclerView(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent, false);

        return new MovieViewHolger(view, onMovieListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolger)holder).title.setText(mMovies.get(position).getTitle());
        ((MovieViewHolger)holder).category.setText(" "+String.join(", ", mMovies.get(position).getGenres()));
        ((MovieViewHolger)holder).movie_year.setText(mMovies.get(position).getYear() + ", ");
        ((MovieViewHolger)holder).ratingBar.setRating((mMovies.get(position).getRating_kinopoisk())/2);
        Glide.with(holder.itemView.getContext())
                .load("https:"+ mMovies.get(position).getPoster())
                .into(((MovieViewHolger)holder).imageView);

    }

    public void setmMovies(List<MovieModel> mMovies) {
        this.mMovies = mMovies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mMovies != null) {
            return mMovies.size();
        }
        return 0;
    }
    public  MovieModel getSelectedMovie(int position){
        if (mMovies != null){
            if(mMovies.size() >0)
                return mMovies.get(position);
        }
        return null;
    }
}
