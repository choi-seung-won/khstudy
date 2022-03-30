package controller;

import model.rentCarDTO;
import java.util.*;

public class RentCarController {
    
    private ArrayList<rentCarDTO> list;
    private int nextId;
    
    public RentCarController() {
        
    }
    
    public void add(rentCarDTO r) {
        r.setId(nextId++);
        list.add(r);
        
    }
    
    public ArrayList<rentCarDTO> selectAll(){
        ArrayList<rentCarDTO> temp = new ArrayList<>();
        for(rentCarDTO r : list) {
            temp.add(new rentCarDTO(r));
        }
        return temp;
    }
    
    public rentCarDTO selectOne(int id) {
        for(rentCarDTO r : list) {
            if(r.getId() == id) {
                return new rentCarDTO(r);
            }
            
        }
        return null;
    }
    
    public void update(rentCarDTO r) {
        list.set(list.indexOf(r), r);
    }
    
    public void delete(int id) {
        rentCarDTO r = new rentCarDTO();
        r.setId(id);
        list.remove(id);
    }

}
