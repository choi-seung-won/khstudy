package controller;

import java.util.*;

import model.MovieDTO;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;

    public MovieController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            MovieDTO m = new MovieDTO();
            m.setTitle("제목" + i);
            m.setSummary("요약" + i);
            m.setGrade(1);
            
            add(m);
        }
    }

    public void add(MovieDTO m) {
        m.setId(nextId++);
        list.add(m);
    }

    public ArrayList<MovieDTO> selectAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO m : list) {
            temp.add(new MovieDTO(m));
        }
        return temp;
    }

    public MovieDTO selectOne(int id) {
        for (MovieDTO m : list) {
            if (m.getId() == id) {
                return new MovieDTO(m);
            }
        }
        return null;
    }

    public void update(MovieDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }

    public void delete(int id) {
        MovieDTO m = new MovieDTO();
        m.setId(id);
        list.remove(m);
    }


}
