package com.example.kinopoisk.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kinopoisk.AppExecutors;
import com.example.kinopoisk.models.MovieModel;
import com.example.kinopoisk.response.MoviesSearcResponse;
import com.example.kinopoisk.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {
    private MutableLiveData<List<MovieModel>> mMovies;
    private static MovieApiClient instance;
    private  RetrieveMoviesRunnable retrieveMoviesRunnable;

    public static MovieApiClient getInstance(){
        if (instance == null){
            instance = new MovieApiClient();
        }
        return instance;
    }

    private  MovieApiClient(){
        mMovies  = new MutableLiveData<>();
    }
    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;
    }


    public  void searchMoviesApi(){
        if (retrieveMoviesRunnable != null){
            retrieveMoviesRunnable = null;
        }
        retrieveMoviesRunnable = new RetrieveMoviesRunnable();

        final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrieveMoviesRunnable);
        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myHandler.cancel(true);
            }
        }, 3000, TimeUnit.MILLISECONDS);
    }
    private class RetrieveMoviesRunnable implements Runnable{

        boolean cancelRequest;
        public RetrieveMoviesRunnable() {

            cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response  = getMovies().execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200){
                    List<MovieModel> list = new ArrayList<>(((MoviesSearcResponse)response.body()).getMovies());
                    mMovies.postValue(list);



                }else {
                    String error = response.errorBody().string();
                    Log.v("Tag", "Error" +error);
                    mMovies.postValue(null);

                }


            } catch (IOException e) {
                e.printStackTrace();
                mMovies.postValue(null);
            }



        }
            private Call<MoviesSearcResponse> getMovies(){
                return Servicey.getMovieApi().searcMovie(Credentials.API_KEY);
            }



    }
}
