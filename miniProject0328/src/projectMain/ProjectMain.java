package projectMain;

import java.util.Scanner;

import viewer.*;

public class ProjectMain {
    
     public static void main(String[] args) {
         
         Scanner scanner = new Scanner(System.in);
         
         TicketViewer ticketViewer = new TicketViewer();
         UserViewer userViewer = new UserViewer();
         
         ticketViewer.setScanner(scanner);
         ticketViewer.setUserViewer(userViewer);
         
         
         
         userViewer.setScanner(scanner);
         userViewer.setTicketViewer(ticketViewer);
         
         userViewer.showIndex();
    }
}
