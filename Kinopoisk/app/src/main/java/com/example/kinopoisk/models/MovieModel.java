package com.example.kinopoisk.models;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;

public class MovieModel implements Parcelable {
    protected MovieModel(Parcel in) {
        id = in.readInt();
        id_kinopoisk = in.readInt();
        url = in.readString();
        type = in.readString();
        title = in.readString();
        description = in.readString();
        year = in.readInt();
        poster = in.readString();
        age = in.readString();
        actors = in.createStringArrayList();
        countries = in.createStringArrayList();
        genres = in.createStringArrayList();
        directors = in.createStringArrayList();
        screenwriters = in.createStringArrayList();
        producers = in.createStringArrayList();
        operators = in.createStringArrayList();
        composers = in.createStringArrayList();
        painters = in.createStringArrayList();
        editors = in.createStringArrayList();
        budget = in.readString();
        rating_kinopoisk = in.readFloat();
        rating_imdb = in.readFloat();
        fees_world = in.readString();
        fees_russia = in.readString();
        premiere_world = in.readString();
        frames = in.createStringArrayList();

    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getId_kinopoisk() {
        return id_kinopoisk;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public String getAge() {
        return age;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getScreenwriters() {
        return screenwriters;
    }

    public List<String> getProducers() {
        return producers;
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<String> getComposers() {
        return composers;
    }

    public List<String> getPainters() {
        return painters;
    }

    public List<String> getEditors() {
        return editors;
    }

    public String getBudget() {
        return budget;
    }

    public float getRating_kinopoisk() {
        return rating_kinopoisk;
    }

    public float getRating_imdb() {
        return rating_imdb;
    }

    public String getFees_world() {
        return fees_world;
    }

    public String getFees_russia() {
        return fees_russia;
    }

    public String getPremiere_world() {
        return premiere_world;
    }


    public List<String> getFrames() {
        return frames;
    }





    private int id;
    private int id_kinopoisk;
    private String url;
    private String type;
    private String title;
    private String description;
    private int year;
    private String poster;
    private String age;
    private List<String> actors;
    private List<String> countries;
    private List<String> genres;
    private List<String> directors;
    private List<String> screenwriters;
    private List<String> producers;
    private List<String> operators;
    private List<String> composers;
    private List<String> painters;
    private List<String> editors;
    private String budget;
    private float rating_kinopoisk;
    private float rating_imdb;
    private String fees_world;
    private String fees_russia;
    private String premiere_world;
    private List<String> frames;




    public MovieModel(int id, int id_kinopoisk, String url, String type, String title, String description, int year, String poster, String age, List<String> actors, List<String> countries, List<String> genres, List<String> directors, List<String> screenwriters, List<String> producers, List<String> operators, List<String> composers, List<String> painters, List<String> editors, String budget, float rating_kinopoisk, float rating_imdb, String fees_world, String fees_russia, String premiere_world,  List<String> frames) {
        this.id = id;
        this.id_kinopoisk = id_kinopoisk;
        this.url = url;
        this.type = type;
        this.title = title;
        this.description = description;
        this.year = year;
        this.poster = poster;
        this.age = age;
        this.actors = actors;
        this.countries = countries;
        this.genres = genres;
        this.directors = directors;
        this.screenwriters = screenwriters;
        this.producers = producers;
        this.operators = operators;
        this.composers = composers;
        this.painters = painters;
        this.editors = editors;
        this.budget = budget;
        this.rating_kinopoisk = rating_kinopoisk;
        this.rating_imdb = rating_imdb;
        this.fees_world = fees_world;
        this.fees_russia = fees_russia;
        this.premiere_world = premiere_world;
        this.frames = frames;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_kinopoisk);
        dest.writeString(url);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(year);
        dest.writeString(poster);
        dest.writeString(age);
        dest.writeStringList(actors);
        dest.writeStringList(countries);
        dest.writeStringList(genres);
        dest.writeStringList(directors);
        dest.writeStringList(screenwriters);
        dest.writeStringList(producers);
        dest.writeStringList(operators);
        dest.writeStringList(composers);
        dest.writeStringList(painters);
        dest.writeStringList(editors);
        dest.writeString(budget);
        dest.writeFloat(rating_kinopoisk);
        dest.writeFloat(rating_imdb);
        dest.writeString(fees_world);
        dest.writeString(fees_russia);
        dest.writeString(premiere_world);
        dest.writeStringList(frames);

    }
}
