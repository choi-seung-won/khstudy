package viewer;

import java.util.Scanner;

import model.UserDTO;

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
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }
}
