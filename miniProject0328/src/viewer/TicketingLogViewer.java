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

    public void setTicketViewer(TicketViewer ticketViewer) {
        this.ticketViewer = ticketViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printAll(int userId) {
        // int userId = logIn.getId();
        ArrayList<TicketingLogDTO> list;
        String message = "";
        int userChoice = 0;
        if (logIn.getUserGrade() == 1) {// 반복구문에러 361answer showViewer add()와 movieviewer seletmovieId참조
            list = updateLog(userId);
            // list = ticketingLogController.ReservedBy(userId);
        } else {
            list = ticketingLogController.selectAll();
        }
        if (list.isEmpty()) {
            System.out.println("예약한 항공편이 없습니다.");
        } else {
            for (TicketingLogDTO t : list) {
                System.out.printf("티켓번호: %d , 예약자번호: %d\n", t.getTicketId(), t.getUserId());

                message = "수정할 티켓의 번호 또는 0을 입력해주세요.";
                userChoice = ScannerUtil.nextInt(scanner, message);
                if (userChoice != 0 && t != null) {
                    int num = userChoice; //setTicketid
                    editLog(logIn.getUserGrade(), userChoice);
                }
            }
        }
    }

    private ArrayList<TicketingLogDTO> filterByUserId(int TicketId, int userId) {
        ArrayList<TicketingLogDTO> list = ticketingLogController.selectAll();
        ArrayList<TicketingLogDTO> result = new ArrayList<>();

        for (TicketingLogDTO t : list) {
            if (userViewer.selectGradeById(t.getUserId()) == userId) {
                result.add(new TicketingLogDTO(t));
            }
        }
        return result;
    }

    private ArrayList<TicketingLogDTO> filterTemp(int userId) {
        // ArrayList<TicketingLogDTO> list = ticketingLogController.selectAll();
        // ArrayList<TicketingLogDTO> result = new ArrayList<>();
        // for(TicketingLogDTO t : list) {// t = empty, = error
        ArrayList<TicketingLogDTO> temp = new ArrayList<TicketingLogDTO>();
        TicketingLogDTO t = new TicketingLogDTO();
        if (ticketViewer.returnUserId(userId) == logIn.getId()
                && t.getTicketId() != ticketViewer.returnTicketId(userId)) {
            t.setUserId(userId);
            t.setTicketId(ticketViewer.returnTicketId(userId));
            ticketingLogController.add(t);
            temp.add(new TicketingLogDTO(t));
        }
        return temp;
    }

    private ArrayList<TicketingLogDTO> updateLog(int id) {
        ArrayList<TicketingLogDTO> temp = new ArrayList<TicketingLogDTO>();
        TicketingLogDTO t = new TicketingLogDTO();

        t.setTicketId(ticketViewer.returnTicketId(id));
        t.setUserId(id);

        ticketingLogController.add(t);

        temp = ticketingLogController.tempOne();
        return temp;
    }

    private void printOne(int id) {
        TicketingLogDTO t = ticketingLogController.selectOne(id);
        if (t != null) {
            System.out.println("\n===============================");
            System.out.printf("티켓고유번호:%d , 티켓번호:%d, 예약자번호:%d, 예약일:%s\n", t.getId(), t.getTicketId(), t.getUserId(),
                    t.getTicketingDate());
            System.out.println("================================\n");
        }else {
            System.out.println("존재하지 않는 티켓입니다.");
        }
    }

    private void editLog(int userGrade, int id) {
        printOne(id);

        String message = "";
        int userChoice;
        if (userGrade == 2) {
            message = "1.일정 수정 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            if (userChoice == 1) {
                updateInfo(id);
            }
        } else {
            message = "1.일정 수정 2.일정 삭제 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                updateInfo(id);
            } else if (userChoice == 2) {
                deleteInfo(id);
                printAll(logIn.getId());
            }
        }
    }

    private void updateInfo(int id) {
        TicketingLogDTO t = ticketingLogController.selectOne(id);

        String message;

        message = "티켓의 새 고유번호를 입력.";
        t.setTicketId(ScannerUtil.nextInt(scanner, message));
        message = "예매일";
        t.setTicketingDate(ScannerUtil.nextLine(scanner, message));
        message = "예매대상자.";
        t.setUserId(ScannerUtil.nextInt(scanner, message));

        ticketingLogController.update(t);

    }

    private void deleteInfo(int id) {

        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            ticketingLogController.delete(id);
            System.out.println("삭제가 완료되었습니다.");
            printAll(logIn.getId());
        }
    }
    
    private void setTicketId(int userChoice) {
        
    }

}
