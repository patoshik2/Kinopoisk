package com.example.kinopoisk.utils;

import com.example.kinopoisk.response.MoviesSearcResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("https://cloud-api.kinopoisk.dev/movies/all/page/666/token/{api_key}")
    Call<MoviesSearcResponse> searcMovie(
            @Path("api_key")  String key

    );
}
