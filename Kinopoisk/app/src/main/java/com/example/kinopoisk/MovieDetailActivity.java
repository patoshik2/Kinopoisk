package com.example.kinopoisk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kinopoisk.adapters.ImageRecyclerView;
import com.example.kinopoisk.models.ImageModel;
import com.example.kinopoisk.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView imgViewDetails;
    private TextView titleDetails, descDetails, year, countries, genres, actors, directors, producers, operators, composer, premiere, age, painters, editors, budget, feesWorld, feesRussia, ratindKinopoisk, ratingImgdb;
    private RatingBar ratingBar;
    private RecyclerView recyclerView;
    private ImageRecyclerView imageRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_img);
        imgViewDetails = findViewById(R.id.imageView_details);
        titleDetails = findViewById(R.id.tv_title_detail);
        descDetails = findViewById(R.id.tv_desc_detail);
        ratingBar = findViewById(R.id.ratingBar_detail);
        year = findViewById(R.id.textView_year);
        countries = findViewById(R.id.textView_countries);
        genres = findViewById(R.id.textView_genres);
        actors = findViewById(R.id.textView_actors);
        directors = findViewById(R.id.textView_directors);
        producers = findViewById(R.id.textView_producers);
        operators = findViewById(R.id.textView_operators);
        composer = findViewById(R.id.textView_composer);
        premiere = findViewById(R.id.textView_premiere);
        age = findViewById(R.id.textView_age);
        painters= findViewById(R.id.textView_painters);
        editors = findViewById(R.id.textView_editors);
        budget  = findViewById(R.id.textView_budget);
        feesWorld = findViewById(R.id.textView_feesWorld);
        feesRussia = findViewById(R.id.textView_feesRussia);
        ratindKinopoisk = findViewById(R.id.textView_ratingKinop);
        ratingImgdb = findViewById(R.id.textView_ratingImdb);
        GetDataFromInternet();

    }

    private void GetDataFromInternet() {
        if (getIntent().hasExtra("movie")){
            MovieModel movieModel = getIntent().getParcelableExtra("movie");
            Glide.with(this)
                    .load("https:"+ movieModel.getPoster())
                    .into(imgViewDetails);
            titleDetails.setText(movieModel.getTitle());
            descDetails.setText(movieModel.getDescription());
            ratingBar.setRating((movieModel.getRating_kinopoisk())/2);
            year.setText(String.valueOf(movieModel.getYear()));
            countries.setText(String.join(", ", movieModel.getCountries()));
            genres.setText(String.join(", ", movieModel.getGenres()));
            actors.setText(String.join(", ", movieModel.getActors()));
            directors.setText(String.join(", ", movieModel.getDirectors()));
            producers.setText(String.join(", ", movieModel.getProducers()));
            operators.setText(String.join(", ", movieModel.getOperators()));
            composer.setText(String.join(", ", movieModel.getComposers()));
            premiere.setText(movieModel.getPremiere_world());
            age.setText(movieModel.getAge());
            painters.setText(String.join(", ", movieModel.getPainters()));
            editors.setText(String.join(", ", movieModel.getEditors()));
            budget.setText(movieModel.getBudget());
            feesWorld.setText(movieModel.getFees_world());
            feesRussia.setText(movieModel.getFees_russia());
            ratingImgdb.setText(String.valueOf(movieModel.getRating_imdb()));
            ratindKinopoisk.setText(String.valueOf(movieModel.getRating_kinopoisk()));

            imageRecyclerView = new ImageRecyclerView();
            recyclerView.setAdapter(imageRecyclerView);
            recyclerView.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false ));
            List<ImageModel> iMovies = new ArrayList<>();
            for (int i =0; i< movieModel.getFrames().size(); i++) {
                iMovies.add(new ImageModel(movieModel.getFrames().get(i)));
            }
            imageRecyclerView.setmMovies(iMovies);


        }
    }
}