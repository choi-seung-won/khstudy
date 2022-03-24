package model;

import java.util.Calendar;
import model.movieDTO;


public class scheduleDTO {

    private int id;
    private int movieid;
    private int theaterid;
    private Calendar showTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public Calendar getShowTime() {
        return showTime;
    }

    public void setShowTime(Calendar showTime) {
        this.showTime = showTime;
    }

    public scheduleDTO() {

    }

    public scheduleDTO(scheduleDTO s) {
        this.id = s.id;
        this.movieid = s.movieid;
        this.theaterid = s.theaterid;

        showTime = Calendar.getInstance();
        showTime.setTime(s.showTime.getTime());

        // 상영시간calendar필요한가?

    }

    public boolean equals(Object o) {

        if (o instanceof scheduleDTO) {
            scheduleDTO s = (scheduleDTO) o;
            return id == s.id;

        }

        return false;
    }

}
