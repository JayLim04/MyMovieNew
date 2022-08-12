package sg.edu.rp.c346.id21033869.mymovienew;

import java.io.Serializable;

import android.os.Bundle;

public class Movies implements Serializable {

    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movies(int id, String title, String genre, int year, String rating){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String movie) {
        this.title = movie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
