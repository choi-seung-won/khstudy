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

    public ArrayList<TicketingLogDTO> selectAll() {
        ArrayList<TicketingLogDTO> temp = new ArrayList<>();
        for (TicketingLogDTO t : list) {
                temp.add(new TicketingLogDTO(t));
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
    
    public ArrayList<TicketingLogDTO> ReservedBy(int userId){
        //arraylist중 userId와 일치하는 데이터만을 리턴
        //중복값처리x-에러
        ArrayList<TicketingLogDTO> temp = new ArrayList<>();
        for(TicketingLogDTO t : list) {
            if(t.getUserId() == userId) {
            temp.add(new TicketingLogDTO(t));
            }
        }
        return temp;
    }
    
    
    public TicketingLogDTO setByUserId(int userId) {//getSingleValue
        for(TicketingLogDTO t : list) {
            if(t.getTicketId() == userId) {
                return new TicketingLogDTO(t);
            }
        }
        return null;
    }
    
    public ArrayList<TicketingLogDTO> tempOne(){
        ArrayList<TicketingLogDTO> temp = new ArrayList<>();
        for(TicketingLogDTO t : list) {
            if(t.getTicketId() != 0 && t != null) {
                temp.add(new TicketingLogDTO(t));
            }
        }
        return temp;
    }
    
    public TicketingLogDTO selectOne(int id) {
        for(TicketingLogDTO t : list) {
            if(t.getId() == id) {
                return new TicketingLogDTO(t);
            }
        }
        return null;
    }
    
    public void update(TicketingLogDTO t) {
        list.set(list.indexOf(t), t);
    }
    
    public void delete(int id) {
        TicketingLogDTO t = new TicketingLogDTO();
        t.setId(id);
        list.remove(t);
    }

}
