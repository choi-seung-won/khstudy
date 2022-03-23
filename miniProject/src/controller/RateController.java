package controller;
// TODO

// 영화별전체평점보기, 영화별평론가/일반관람객평점보기

import java.util.ArrayList;
import java.util.Calendar;

import model.RateDTO;

public class RateController {

    private ArrayList<RateDTO> list;
    private int nextId;

    public RateController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 3; i++) {

            RateDTO r = new RateDTO();
            r.setMovieId(2);
            r.setWriterId(3);
            r.setContent("내용" + i);

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

    public ArrayList<RateDTO> selectExclusive(int movieId) {//작동안함

        ArrayList<RateDTO> temp = new ArrayList<>();
        for (RateDTO r : list) {
            if (r.getRate() == 3) {
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
