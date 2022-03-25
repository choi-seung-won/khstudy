package controller;

import model.ShowDTO;

import java.util.*;

public class ShowController {
    private ArrayList<ShowDTO> list;
    private int nextId;

    public ShowController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            ShowDTO s = new ShowDTO();
            s.setMovieId(i);
            s.setTheaterId(i);
            s.setShowTime((i + 9) + ":00 ~" + (i + 11) + ":30");

            add(s);
        }

    }

    public void add(ShowDTO s) {
        s.setId(nextId++);
        list.add(s);

    }

    public ArrayList<ShowDTO> selectAllByTheaterId(int theaterId) {
        ArrayList<ShowDTO> temp = new ArrayList<>();
        for (ShowDTO s : list) {
            if (s.getTheaterId() == theaterId) {
                temp.add(new ShowDTO(s));
            }
        }
        return temp;
    }

    public ArrayList<ShowDTO> selectAllByMovieId(int movieId) {
        ArrayList<ShowDTO> temp = new ArrayList<>();
        for (ShowDTO s : list) {
            if (s.getTheaterId() == movieId) {
                temp.add(new ShowDTO(s));
            }
        }
        return temp;
    }

    public void update(ShowDTO s) {
        list.set(list.indexOf(s), s);
    }

    public void delete(int id) {
        ShowDTO s = new ShowDTO();
        s.setId(id);

        list.remove(s);
    }

    public ShowDTO selectOne(int id) {
        for (ShowDTO s : list) {
            if (s.getId() == id) {
                return new ShowDTO(s);
            }
        }
        return null;

    }

    public void deleteByMovieId(int movieId) {
        for (int i = 0; i < list.size(); i++) {
            ShowDTO s = list.get(i);
            if (s.getMovieId() == movieId) {
                list.remove(i);
                i = -1;
            }
        }

    }

    public void deleteByTheaterId(int theaterId) {
        for (int i = 0; i < list.size(); i++) {
            ShowDTO s = list.get(i);
            if (s.getMovieId() == theaterId) {
                list.remove(i);
                i = -1;
            }
        }

    }

}
