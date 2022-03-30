package projectMain;

import java.util.Scanner;

import viewer.*;

public class ProjectMain {
    
     public static void main(String[] args) {
         
         Scanner scanner = new Scanner(System.in);
         UserViewer userViewer = new UserViewer();
         
         TicketViewer ticketViewer = new TicketViewer();
         TicketingLogViewer ticketingLogViewer = new TicketingLogViewer();
         RentCarViewer rentCarViewer = new RentCarViewer();
         RentCarLogViewer rentCarLogViewer = new RentCarLogViewer();
         HotelViewer hotelViewer = new HotelViewer();
         HotelRoomViewer hotelRoomViewer = new HotelRoomViewer();
         BookingLogViewer bookingLogViewer = new BookingLogViewer();
         
         ticketViewer.setScanner(scanner);
         ticketViewer.setUserViewer(userViewer);
         ticketViewer.setTicketingLogViewer(ticketingLogViewer);
         
         ticketingLogViewer.setScanner(scanner);
         ticketingLogViewer.setTicketViewer(ticketViewer);
         ticketingLogViewer.setUserViewer(userViewer);
         
         userViewer.setScanner(scanner);
         userViewer.setTicketViewer(ticketViewer);
         userViewer.setTicketingLogViewer(ticketingLogViewer);
         userViewer.setRentCarViewer(rentCarViewer);
         userViewer.setRentCarLogViewer(rentCarLogViewer);
         userViewer.setHotelViewer(hotelViewer);
         userViewer.setHotelRoomViewer(hotelRoomViewer);
         userViewer.setBookingLogViewer(bookingLogViewer);
         
         userViewer.showIndex();
    }
}
