package model;

import java.util.Calendar;
import model.MovieDTO;

public class ShowDTO {

    private int id;
    private int movieId;
    private int theaterId;
    private String showTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieid) {
        this.movieId = movieid;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterid) {
        this.theaterId = theaterid;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public ShowDTO() {

    }

    public ShowDTO(ShowDTO s) {
        this.id = s.id;
        this.movieId = s.movieId;
        this.theaterId = s.theaterId;
        this.showTime = s.showTime;
        // 상영시간calendar필요한가?

    }

    public boolean equals(Object o) {

        if (o instanceof ShowDTO) {
            ShowDTO s = (ShowDTO) o;
            return id == s.id;

        }

        return false;
    }

}
