package controller;
// TODO

// 영화목록/개별보기,(어드민=userate체크)새로운영화등록/수정/삭제

import java.util.*;

import model.UserDTO;
import model.movieDTO;
import viewer.UserViewer;

public class movieController {

    private ArrayList<movieDTO> list;
    private int nextId;
    private UserViewer userViewer;
    private UserDTO userDTO;

    public movieController() {

        list = new ArrayList<>();
        nextId = 1;
        userViewer = new UserViewer();
        userDTO = new UserDTO();

        for (int i = 1; i < 3; i++) {
            movieDTO m = new movieDTO();
            m.setName("제목" + i);
            m.setPlot("ㅁ ㄴ ㅇ" + i);
            m.setMovieRateCode(i);
            add(m);
        }
    }

    public void add(movieDTO m) {
        m.setId(nextId++);

        list.add(m);
    }

    public ArrayList<movieDTO> selectAll() {
        ArrayList<movieDTO> temp = new ArrayList<>();
        for (movieDTO m : list) {
            temp.add(new movieDTO(m));
        }
        return temp;
    }

    public movieDTO selectOne(int id) {
        for (movieDTO m : list) {
            if (m.getId() == id) {
                return new movieDTO(m);
            }
        }

        return null;
    }

    public void update(movieDTO m) {

        list.set(list.indexOf(m), m);

    }

    public void delete(int id) {
        movieDTO m = new movieDTO();

        m.setId(id);

        list.remove(m);
    }

    public boolean verifyUserRate(int rate) {
        UserDTO u = new UserDTO();

        if (u.getId() == rate) {
            return true;
        }
        return false;
    }

}
