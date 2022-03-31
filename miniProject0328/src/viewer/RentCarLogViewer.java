package viewer;

import java.text.*;
import java.util.*;

import model.UserDTO;
import model.rentCarDTO;
import model.rentCarLogDTO;
import util.ScannerUtil;
import controller.RentCarLogController;

public class RentCarLogViewer {
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    
    public void setTicketViewer(TicketViewer ticketViewer) {
        this.ticketViewer = ticketViewer;
    }
    
    public void setTicketingLogViewer(TicketingLogViewer ticketingLogViewer) {
        this.ticketingLogViewer = ticketingLogViewer;
    }
    public void setRentCarViewer(RentCarViewer rentCarViewer) {
        this.rentCarViewer = rentCarViewer;
    }
    
    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }
    
    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }
    
    public void setBookingLogViewer(BookingLogViewer bookingLogViewer) {
        this.bookingLogViewer = bookingLogViewer;
    }
    
    private Scanner scanner;
    private UserViewer userViewer;
    private TicketViewer ticketViewer;
    private TicketingLogViewer ticketingLogViewer;
    private RentCarViewer rentCarViewer;
    private HotelViewer hotelViewer;
    private HotelRoomViewer hotelRoomViewer;
    private BookingLogViewer bookingLogViewer;

    private UserDTO logIn;
    private rentCarDTO rentCarDTO;
    private rentCarLogDTO rentCarLogDTO;
    private RentCarLogController rentCarLogController;
    
    
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }
    
    public void showMain() {
        ArrayList<rentCarLogDTO> list;
        String message = "";
        int userChoice = 0;
        if (logIn.getUserGrade() == 1) {
            list = rentCarLogController.selectSpecific(userChoice);
        }else {
            list = rentCarLogController.selectAll();
        }
    }
}
