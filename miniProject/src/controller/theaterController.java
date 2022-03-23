package controller;
// TODO

// 극장목록/개별보기,상영중인영화목록보기
// (어드민-userrate체크)새로운극장등록/기존수정/삭제

import java.util.ArrayList;

import model.UserDTO;
import model.theaterDTO;
import viewer.UserViewer;

public class theaterController {

    private ArrayList<theaterDTO> list;
    private int nextId;
    private UserDTO userDTO;
    
    public theaterController() {
        
        list = new ArrayList<>();
        nextId = 1;
        userDTO = new UserDTO();
        
        for (int i = 1; i <= 3; i++) {

            theaterDTO t = new theaterDTO();

            t.setName("임의의 상영관 이름" + i);
            t.setCallNum(123456789);
            t.setLocation("LA어딘가" + i);
            
            add(t);

        }
        
    }
    
    public void add(theaterDTO t) {
        t.setId(nextId++);
        list.add(t);
        
    }
    
    public ArrayList<theaterDTO> selectAll() {

        ArrayList<theaterDTO> temp = new ArrayList<>();
        for (theaterDTO t: list) {
            temp.add(new theaterDTO(t));
        }
        return temp;
    }
    
    public theaterDTO selectOne(int id){
        for(theaterDTO t : list) {
            if(t.getId() == id) {
                return new theaterDTO(t);
            }
        }
        return null;
        
    }
    
    public void update(theaterDTO t) {
        
        list.set(list.indexOf(t), t);
        
    }
    
    public void delete(int id) {
        
        theaterDTO t = new theaterDTO();
        t.setId(id);
        list.remove(id);
        
    }
    
    
    
}
