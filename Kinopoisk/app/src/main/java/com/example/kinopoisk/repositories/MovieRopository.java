package com.example.kinopoisk.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kinopoisk.models.MovieModel;
import com.example.kinopoisk.request.MovieApiClient;

import java.util.List;

public class MovieRopository {

    private  static MovieRopository instance;
    private MovieApiClient movieApiClient;
    public static MovieRopository getInstance(){
        if(instance == null){
            instance = new MovieRopository();
        }
        return instance;
    }
    private MovieRopository(){
       movieApiClient = MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies(){
        return  movieApiClient.getMovies();
    }

    public  void searchMovieApi(){
        movieApiClient.searchMoviesApi();
    }

}
