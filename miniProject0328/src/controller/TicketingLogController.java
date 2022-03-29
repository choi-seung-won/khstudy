package controller;

import java.util.*;

import model.TicketingLogDTO;

public class TicketingLogController {

    private ArrayList<TicketingLogDTO> list;
    private int nextId;

    public TicketingLogController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void add(TicketingLogDTO t) {
        t.setId(nextId++);
        list.add(t);
    }

    public ArrayList<TicketingLogDTO> selectAll(int ticketId) {
        ArrayList<TicketingLogDTO> temp = new ArrayList<>();
        for (TicketingLogDTO t : list) {
            if (t.getTicketId() == ticketId) {
                temp.add(new TicketingLogDTO(t));
            }
        }
        return temp;
    }

    public void deleteByTicketId(int ticketId) {
        for (int i = 0; i < list.size(); i++) {
            TicketingLogDTO t = list.get(i);
            if (t.getTicketId() == ticketId) {
                list.remove(i);
                i = -1;
            }
        }
    }
    
    public TicketingLogDTO setByUserId(int userId) {//userController>auth
        for(TicketingLogDTO t : list) {
            if(t.getTicketId() == userId) {
                return new TicketingLogDTO(t);
            }
        }
        return null;
    }

}
