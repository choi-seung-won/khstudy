package controller;
// TODO

// 영화별전체평점보기, 영화별평론가/일반관람객평점보기

import java.util.ArrayList;
import java.util.Calendar;

import model.RateDTO;
import model.UserDTO;
import model.theaterDTO;

public class RateController {

    private ArrayList<RateDTO> list;
    private int nextId;
    private UserDTO logIn;
    private theaterDTO theaterDTO;

    public RateController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 3; i++) {

            RateDTO r = new RateDTO();
            logIn = new UserDTO();
            theaterDTO = new theaterDTO();
            r.setMovieId(1);
            r.setWriterId(i);
            r.setContent("내용" + i);
            r.setRate(i);
            r.setId(nextId);
            add(r);

        }

    }

    public void add(RateDTO r) {
        r.setId(nextId++);// ?

        r.setWrittenDate(Calendar.getInstance());
        list.add(r);
    }

    public ArrayList<RateDTO> selectAll(int movieId) {

        ArrayList<RateDTO> temp = new ArrayList<>();

        for (RateDTO r : list) {// for~list_maxsize

            if (r.getMovieId() == movieId) {
                temp.add(new RateDTO(r));
            }

        }
        return temp;
    }

    public ArrayList<RateDTO> selectExclusive(int movieId) {

        ArrayList<RateDTO> temp = new ArrayList<>();
        for (RateDTO r : list) {
            if (r.getWriterId() == 2 && r.getMovieId() == movieId) {
                temp.add(new RateDTO(r));
            }
        }
        return temp;
    }

    public ArrayList<RateDTO> selectPublic(int movieId) {

        ArrayList<RateDTO> temp = new ArrayList<>();
        for (RateDTO r : list) {
            if (r.getWriterId() == 1 && r.getMovieId() == movieId) {
                temp.add(new RateDTO(r));
            }
        }
        return temp;
    }

    public void deleteByWriterId(int writerId) {
        for (int i = 0; i < list.size(); i++) {

            RateDTO r = list.get(i);

            if (r.getWriterId() == writerId) {
                list.remove(i);
                i = -1;
            }

        }
    }

}
