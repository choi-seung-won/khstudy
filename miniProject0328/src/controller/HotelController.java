package controller;
import java.util.*;
import model.hotelDTO;

public class HotelController {
    
    private ArrayList<hotelDTO> list;
    private int nextId;
    
    public HotelController() {
        list = new ArrayList<>();
        nextId = 1;
        
        for(int i = 1; i <= 4 ; i ++) {
            
            hotelDTO h = new hotelDTO();
            h.setName("이름" + i);
            h.setGrade(i);
            h.setLocation("위치"+i);
            h.setCallNum("02"+i);
            
            add(h);
        }
    }
    
    public void add(hotelDTO h) {
        h.setId(nextId++);
        list.add(h);
    }
    public ArrayList<hotelDTO> selectAll(){
        ArrayList<hotelDTO> temp = new ArrayList<>();
        for(hotelDTO h : list) {
            temp.add(new hotelDTO(h));
        }
        return temp;
    }
    
    public hotelDTO selectOne(int id) {
        for(hotelDTO h : list) {
            if(h.getId() == id) {
                return new hotelDTO(h);
            }
        }
        return null;
    }
    
    public void update(hotelDTO h) {
        list.set(list.indexOf(h), h);
    }
    
    public void delete(int id) {
        hotelDTO h = new hotelDTO();
        h.setId(id);
        list.remove(h);
    }
}
