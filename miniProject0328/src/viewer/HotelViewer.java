package viewer;

import java.util.Scanner;

import controller.HotelController;
import model.UserDTO;

public class HotelViewer {
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

    public void setRentCarLogViewer(RentCarLogViewer rentCarLogViewer) {
        this.rentCarLogViewer = rentCarLogViewer;
    }

    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }

    public void setBookingLogViewer(BookingLogViewer bookingLogViewer) {
        this.bookingLogViewer = bookingLogViewer;
    }

    private UserViewer userViewer;
    private TicketViewer ticketViewer;
    private TicketingLogViewer ticketingLogViewer;
    private RentCarViewer rentCarViewer;
    private RentCarLogViewer rentCarLogViewer;
    private HotelRoomViewer hotelRoomViewer;
    private BookingLogViewer bookingLogViewer;

    private Scanner scanner;
    private UserDTO logIn;
    private HotelController hotelController;

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }

    public HotelViewer() {
        hotelController = new HotelController();
    }
    
    public void showMenu() {
        
        if(logIn.getUserGrade() == 1) {
            
        }else {
            
        }
        
    }

}
