package controller;

import java.util.ArrayList;

import model.rentCarLogDTO;

public class RentCarLogController {
    private ArrayList<rentCarLogDTO> list;
    private int nextId;

    public RentCarLogController() {
        list = new ArrayList<>();
        nextId = 1;

    }

    public void add(rentCarLogDTO r) {
        r.setId(nextId++);
        list.add(r);
    }

    public ArrayList<rentCarLogDTO> selectAll() {
        ArrayList<rentCarLogDTO> temp = new ArrayList<>();
        for (rentCarLogDTO r : list) {
            temp.add(new rentCarLogDTO(r));
        }
        return temp;
    }

    public ArrayList<rentCarLogDTO> selectSpecific(int rentCarId) {
        ArrayList<rentCarLogDTO> temp = new ArrayList<>();
        for (rentCarLogDTO r : list) {
            if (r.getRentCarId() == rentCarId) {
                temp.add(new rentCarLogDTO(r));
            }
        }
        return temp;
    }
    
    public ArrayList<rentCarLogDTO> selectNotReserved(){//tempOne
        
    }

    public void deleteByCarId(int rentCarId) {
        for (int i = 0; i < list.size(); i++) {
            rentCarLogDTO r = list.get(i);
            if (r.getRentCarId() == rentCarId) {
                list.remove(i);
                i = -1;
            }
        }
    }

}
