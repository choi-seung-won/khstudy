package controller;
import java.util.ArrayList;

import model.bookingLogDTO;

public class BookingLogController {
    private ArrayList<bookingLogDTO> list;
    private int nextId;

    public BookingLogController() {
        list = new ArrayList<>();
        nextId = 1;
    }
    
    public void add(bookingLogDTO b) {
        b.setId(nextId++);
        list.add(b);
    }
    
    public ArrayList<bookingLogDTO> selectAll(int roomId){
        ArrayList<bookingLogDTO> temp = new ArrayList<>();
        
        for(bookingLogDTO b : list) {
            if(b.getRoomId() == roomId) {
                temp.add(new bookingLogDTO(b));
            }
        }
        return temp;
    }
    
    public void deleteByRoomId(int roomId) {
        for(int i = 0 ; i < list.size() ; i ++) {
            bookingLogDTO b = list.get(i);
            if(b.getRoomId() == roomId) {
                list.remove(i);
                i = -1;
            }
        }
    }
    
    public void deleteByHotelId(int hotelId) {
        for(int i = 0 ; i < list.size(); i ++) {
            bookingLogDTO b = list.get(i);
            if(b.getHotelId() == hotelId) {
                list.remove(i);
                i = -1;
            }
        }
    }

}
