package model;

import java.util.Calendar;

public class RateDTO {

    private int id;
    private int writerId;
    private int movieId;
    private int rate;
    
    private String content;
    private Calendar writtenDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }

    public RateDTO() {

    }

    public RateDTO(RateDTO r) {

        id = r.id;
        content = r.content;
        movieId = r.movieId;
        rate = r.rate;
        writerId = r.writerId;

        writtenDate = Calendar.getInstance();
        writtenDate.setTime(r.writtenDate.getTime());
    }

    public boolean equals(Object o) {
        if (o instanceof RateDTO) {
            RateDTO r = (RateDTO) o;
            return id == r.id;
        }
        return false;
    }

}
