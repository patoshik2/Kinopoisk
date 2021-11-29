package com.example.kinopoisk.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kinopoisk.models.MovieModel;
import com.example.kinopoisk.repositories.MovieRopository;

import java.util.List;

public class MovieListViewModel extends ViewModel {


    private MovieRopository movieRopository;

    public MovieListViewModel() {
        movieRopository = MovieRopository.getInstance();

    }

    public LiveData<List<MovieModel>> getMovies(){
        return  movieRopository.getMovies();
    }

    public void searchMovieApi(){
        movieRopository.searchMovieApi();
    }
}
