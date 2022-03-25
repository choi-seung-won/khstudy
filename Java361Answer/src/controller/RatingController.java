package controller;

import java.util.ArrayList;

import model.RatingDTO;

public class RatingController {
    private ArrayList<RatingDTO> list;
    private int nextId;

    public RatingController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void add(RatingDTO r) {
        r.setId(nextId++);// ?
        list.add(r);
    }

    public ArrayList<RatingDTO> selectAll(int movieId) {
        ArrayList<RatingDTO> temp = new ArrayList<>();
        for (RatingDTO r : list) {// for~list_maxsize
            if (r.getMovieId() == movieId) {
                temp.add(new RatingDTO(r));
            }
        }
        return temp;
    }
    
    public void deleteByMovieId(int movieId) {
        for (int i = 0; i < list.size(); i++) {
            RatingDTO r = list.get(i);
            if (r.getMovieId() == movieId) {
                list.remove(i);
                i = -1;
            }
        }
    }
    
    public void deleteByWriterId(int writerId) {
        for (int i = 0; i < list.size(); i++) {
            RatingDTO r = list.get(i);
            if (r.getWriterId() == writerId) {
                list.remove(i);
                i = -1;
            }
        }
    }
    
    

    public ArrayList<RatingDTO> selectExclusive(int movieId) {

        ArrayList<RatingDTO> temp = new ArrayList<>();
        for (RatingDTO r : list) {
            if (r.getWriterId() == 2 && r.getMovieId() == movieId) {
                temp.add(new RatingDTO(r));
            }
        }
        return temp;
    }

    public ArrayList<RatingDTO> selectPublic(int movieId) {

        ArrayList<RatingDTO> temp = new ArrayList<>();
        for (RatingDTO r : list) {
            if (r.getWriterId() == 1 && r.getMovieId() == movieId) {
                temp.add(new RatingDTO(r));
            }
        }
        return temp;
    }



}
