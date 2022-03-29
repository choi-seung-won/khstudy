package controller;
import java.util.ArrayList;

import model.TicketDTO;


public class TicketController {
    private ArrayList<TicketDTO> list;
    private int nextId;
    
    public TicketController() {
        list = new ArrayList<>();
        nextId = 1;
        
        for(int i = 1 ; i <= 4 ; i ++) {
            TicketDTO t = new TicketDTO();
            t.setArrivalTime(i + "시간");
            t.setDeparture("어딘가로부터" + i);
            t.setDepartureTime(i + "시간후");
            t.setDestination("어딘가까지" + i);
            t.setSeat(i+"번좌석");
            
            add(t);
        }
    }
    
    public void add(TicketDTO t) {
        t.setId(nextId++);
        list.add(t);
    }
    
    public ArrayList<TicketDTO> selectAll(){
        ArrayList<TicketDTO> temp = new ArrayList<>();
        for(TicketDTO t : list) {
            temp.add(new TicketDTO(t));
        }
        return temp;
    }
    
    public TicketDTO selectOne(int id) {
        for(TicketDTO t : list) {
            if(t.getId() == id) {
                return new TicketDTO(t); 
            }
        }
        return null;
    }
    
    public void update(TicketDTO t) {
        list.set(list.indexOf(t), t);
    }
    
    public void delete(int id) {
        TicketDTO t = new TicketDTO();
        t.setId(id);
        list.remove(t);
    }
    
    public ArrayList<TicketDTO> filterByReserved(){//예약되지않은것만
        ArrayList<TicketDTO> temp = new ArrayList<>();
        for(TicketDTO t : list) {
            if(t.getReserved() == false) {
                temp.add(t);
            }
        }
        return temp;
    }
    
    public boolean filterByReserved(int id){//에러
        ArrayList<TicketDTO> temp;
        for(TicketDTO t : list) {
            if(t.getReserved() == true) {
                
            }
        }
        TicketDTO t = new TicketDTO();
        t.setId(id);
        if(t.getReserved() == true) {
            return true;
        }else {
            return false;
        }
    }

}
