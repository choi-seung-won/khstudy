package controller;

import java.util.ArrayList;

import model.TheaterDTO;

public class TheaterController {

    private ArrayList<TheaterDTO> list;
    private int nextId;

    public TheaterController() {

        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            TheaterDTO t = new TheaterDTO();
            t.setName("극장" + i);
            t.setAddress("주소 " + i);
            t.setPhoneNumber("02-" + i);
            add(t);
        }
    }

    public void add(TheaterDTO t) {
        t.setId(nextId++);
        list.add(t);
    }

    public ArrayList<TheaterDTO> selectAll() {
        ArrayList<TheaterDTO> temp = new ArrayList<>();
        for (TheaterDTO t : list) {
            temp.add(new TheaterDTO(t));
        }
        return temp;
    }

    public TheaterDTO selectOne(int id) {
        for (TheaterDTO t : list) {
            if (t.getId() == id) {
                return new TheaterDTO(t);
            }
        }
        return null;
    }

    public void update(TheaterDTO t) {
        int index = list.indexOf(t);
        list.set(index, t);

    }

    public void delete(int id) {
            TheaterDTO t = new TheaterDTO();
            t.setId(id);    
            list.remove(t);

    }

}
