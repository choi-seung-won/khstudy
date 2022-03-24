package controller;
// TODO

import model.movieDTO;

// (어드민전용)새로운상영정보등록,기존수정,삭제

import model.scheduleDTO;
import model.theaterDTO;

import java.util.*;

public class scheduleController {

    private ArrayList<scheduleDTO> list;
    private int nextId;

    public scheduleController() {

        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i < 3; i++) {

            scheduleDTO s = new scheduleDTO();
            s.setId(i);
            s.setMovieid(i);
            s.setTheaterid(i);

            add(s);
        }

    }

    private movieDTO movieDTO;



    public void add(scheduleDTO s) {
        s.setId(nextId++);
        s.setShowTime(Calendar.getInstance());
        list.add(s);

    }

    public ArrayList<scheduleDTO> selectAll(int theaterId) {
        ArrayList<scheduleDTO> temp = new ArrayList<>();
        for (scheduleDTO s : list) {

            if (s.getTheaterid() == theaterId) {

                temp.add(new scheduleDTO(s));
            }

        }

        return temp;

    }
    //
    public scheduleDTO selectOne(int id) {
        for(scheduleDTO s : list) {
            if(s.getId() == id) {
                return new scheduleDTO(s);
            }
        }
        return null;
    }
    //
    public void update(scheduleDTO s) {
        list.set(list.indexOf(s), s);
    }
    
    public void deleteByMovieId(int movieId) {
        
        for(int i = 0 ; i < list.size(); i ++) {
            
            scheduleDTO s = list.get(i);
            if(s.getMovieid() == movieId) {
                list.remove(i);
                i = - 1;
                
            }
        }
    }
    

}
