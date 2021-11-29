package com.example.kinopoisk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinopoisk.adapters.MovieRecyclerView;
import com.example.kinopoisk.adapters.OnMovieListener;
import com.example.kinopoisk.models.MovieModel;
import com.example.kinopoisk.request.Servicey;
import com.example.kinopoisk.response.MoviesSearcResponse;
import com.example.kinopoisk.utils.Credentials;
import com.example.kinopoisk.utils.MovieApi;
import com.example.kinopoisk.viewmodels.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerView;

    //ViewModel
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        ConfigureRecyclerView();
        ObserveAnyChange();
        searchMovieApi();
    }

    private  void  ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels!=null){
                    for (MovieModel movieModel: movieModels){
                        movieRecyclerView.setmMovies(movieModels);
                    }
                }

            }
        });
    }


    private void searchMovieApi(){
        movieListViewModel.searchMovieApi();
    }


    private  void  ConfigureRecyclerView(){
        movieRecyclerView = new MovieRecyclerView(this);
        recyclerView.setAdapter(movieRecyclerView);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
    }


    @Override
    public void onMovieClick(int position) {
        Intent intent  = new Intent(this,MovieDetailActivity.class);
        intent.putExtra("movie", movieRecyclerView.getSelectedMovie(position));
        startActivity(intent);
    }

}