package com.example.kinopoisk.response;

import com.example.kinopoisk.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesSearcResponse {

    @SerializedName("movies")
    @Expose
    private List<MovieModel> movies;
    public  List<MovieModel> getMovies(){
        return movies;
    }
}
