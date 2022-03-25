package model;

import java.util.Calendar;

public class RatingDTO {

    private int id;
    private int movieId;
    private int writerId;
    private int rate;
    private String critic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCritic() {
        return critic;
    }

    public void setCritic(String critic) {
        this.critic = critic;
    }

    public RatingDTO() {

    }

    public RatingDTO(RatingDTO r) {
        id = r.id;
        movieId = r.movieId;
        writerId = r.writerId;
        rate = r.rate;
        critic = r.critic;

    }

    public boolean equals(Object o) {
        if (o instanceof RatingDTO) {
            RatingDTO r = (RatingDTO) o;
            return id == r.id;
        }
        return false;
    }

}
