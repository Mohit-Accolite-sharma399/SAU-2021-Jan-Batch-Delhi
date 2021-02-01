package com.assignment.kafka.springbootwithkafka.models;

public class Movie {
    private String movieName;
    private int year;
    private String genre;
    private String actor;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Movie: { " +
                "movieName: " + movieName +
                ", year: " + year +
                ", genre: " + genre +
                ", actor: " + actor +
                " }";
    }
}
