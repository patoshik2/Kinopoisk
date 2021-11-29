package com.example.kinopoisk.response;

import com.example.kinopoisk.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("movies")
    @Expose
    private MovieModel model;
    public  MovieModel getModel(){
        return model;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "model=" + model +
                '}';
    }
}
