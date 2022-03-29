package viewer;

import java.util.*;
import controller.TicketingLogController;
import model.*;

import util.ScannerUtil;

public class TicketingLogViewer {

    private UserViewer userViewer;
    private TicketViewer ticketViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private TicketingLogController ticketingLogController;

    public TicketingLogViewer() {
        ticketingLogController = new TicketingLogController();
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printAll(int userId, boolean reserved) {
        ArrayList<TicketingLogDTO> list;
        TicketingLogDTO t = new TicketingLogDTO();
        String message = "";
        int userChoice = 0;
        if(reserved == false) {
            list = ticketingLogController.selectAll(userId);
        }else {
            list = filterByUserId(t.getTicketId() ,userId);
            
        }
        list = ticketingLogController.selectAll(userId);
        if (list.isEmpty()) {
            System.out.println("예약한 항공편이 없습니다.");
        } else {

        }
    }

    private ArrayList<TicketingLogDTO> filterByUserId(int TicketId, int userId) {
        ArrayList<TicketingLogDTO> list = ticketingLogController.selectAll(TicketId);
        ArrayList<TicketingLogDTO> result = new ArrayList<>();

        for (TicketingLogDTO t : list) {
            if (userViewer.selectGradeById(t.getUserId()) == userId) {
                result.add(new TicketingLogDTO(t));
            }
        }
        return result;
    }
}
