package viewer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import controller.TicketingLogController;
import model.TicketingLogDTO;
import model.TicketDTO;
import model.UserDTO;
import util.ScannerUtil;

public class TicketingLogViewer {

    public int loopChecker = 1;

    private UserViewer userViewer;
    private TicketViewer ticketViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private TicketingLogController ticketingLogController;

    public TicketingLogViewer() {
        ticketingLogController = new TicketingLogController();

        // 생성자로 값추가.

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

    public void printAll(int userId) {//deadCode
        // int userId = logIn.getId();
        ArrayList<TicketingLogDTO> list = new ArrayList<>();

        String message = "";
        int userChoice = 0;
        if (logIn.getUserGrade() == 1) {// 반복구문에러 361answer showViewer add()와 movieviewer seletmovieId참조
            // list = updateLog(userId);
            list = ticketingLogController.tempOne();
        } else {
            list = ticketingLogController.selectAll();
        }
        if (list.isEmpty()) {
            System.out.println("예약한 항공편이 없습니다.");
        } else {
            for (TicketingLogDTO t : list) {
                System.out.printf("티켓번호: %d , 예약자번호: %d\n", t.getTicketId(), t.getUserId());
            }
            message = "수정할 티켓의 번호 또는 0을 입력해주세요.";
            userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice != 0) {
                int num = userChoice; // setTicketid
                num = ticketViewer.returnTicketId(userChoice);
                editLog(logIn.getUserGrade(), num);
            }
        }
    }

    public void setReservedTicket() {
        TicketingLogDTO t = new TicketingLogDTO();
        for (int i = 0; i < ticketViewer.getSizeofTicketArray(); i++) {
            if (i == ticketViewer.setTemp(i)) {
                t.setUserId(ticketViewer.selectReservedId(i));
                t.setTicketId(ticketViewer.returnTicketId(logIn.getId()));
                t.setTicketingDate("anyway");

                ticketingLogController.add(t);
            }
        }

    }

    public void printSetValue() {//main

        ArrayList<TicketingLogDTO> list;
        String message = "";
        int userChoice = 0;
        if (logIn.getUserGrade() == 1) {
            list = ticketingLogController.tempOne();
        } else {
            list = ticketingLogController.selectAll();
        }

        if (list.isEmpty()) {
            System.out.println("예약된 항공편이 없습니다.");
        } else {
            for (TicketingLogDTO t : list) {
                System.out.printf("고유번호: %d ,티켓번호: %d , 예약자번호: %d\n", t.getId(), t.getTicketId(), t.getUserId());
            }

            message = "수정할 티켓의 번호 또는 0을 입력해주세요.";
            userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice != 0) {
                int num = getTixId(userChoice); // setTicketid
                editLog(logIn.getUserGrade(), num);
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

    public ArrayList<TicketingLogDTO> updateLog(int id) {

        ArrayList<TicketingLogDTO> temp = new ArrayList<TicketingLogDTO>();
        TicketingLogDTO t = new TicketingLogDTO();

        t.setTicketId(ticketViewer.returnTicketId(id));
        t.setUserId(id);

        ticketingLogController.add(t);

        temp = ticketingLogController.tempOne();
        return temp;
    }

    public void updateLogTest() {// 리턴없이값연동/초기화만
        int size = ticketViewer.getReserverdTicketSize();
        ArrayList<TicketingLogDTO> temp = new ArrayList<TicketingLogDTO>();
        TicketingLogDTO t = new TicketingLogDTO();
        //
        ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
        list = ticketViewer.setTicketId();
            for (TicketDTO td : list) {// ticketdto데이터연동,차후해당viewer에서datatype연동remove도체크
                if (t.getTicketId() != td.getId() ) {
                    t.setTicketId(td.getId());
                    t.setUserId(td.getReservedUserId());
                    ticketingLogController.add(t);
                    loopChecker++;
                }
        }
    }
    
    private void insertLogByOrigin() {//deadcode
        TicketingLogDTO t = new TicketingLogDTO();
        ArrayList<TicketDTO> list = ticketViewer.setTicketId();
        for(TicketDTO td : list) {
        }
    }

    private void printOne(int id) {// deadcode
        TicketingLogDTO t = ticketingLogController.selectOne(id);
        if (t != null) {
            System.out.println("\n===============================");
            System.out.printf("티켓고유번호:%d , 티켓번호:%d, 예약자번호:%d, 예약일:%s\n", t.getId(), t.getTicketId(), t.getUserId(),
                    t.getTicketingDate());
            System.out.println("================================\n");
        } else {
            System.out.println("존재하지 않는 티켓입니다.");
        }
    }

    private void editLog(int userGrade, int id) {

        TicketingLogDTO t = ticketingLogController.selectOne(id);
        if (t != null) {
            System.out.println("\n===============================");
            System.out.printf("티켓고유번호:%d , 티켓번호:%d, 예약자번호:%d, 예약일:%s\n", t.getId(), t.getTicketId(), t.getUserId(),
                    t.getTicketingDate());
            System.out.println("================================\n");

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
                }
            }
        } else {
            System.out.println("존재하지 않는 티켓입니다.");
        }
    }

    private void updateInfo(int id) {
        if (ticketingLogController.selectOne(id) != null) {
            TicketingLogDTO t = ticketingLogController.selectOne(id);

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            String message;

            message = "티켓의 새 번호를 입력.";
            t.setTicketId(ScannerUtil.nextInt(scanner, message));
            message = "예매일";
            t.setTicketingDate(strDate + t.getId());
            message = "예매대상자.";
            t.setUserId(ScannerUtil.nextInt(scanner, message));

            ticketingLogController.update(t);
        }

        printAll(logIn.getId());
    }

    private void deleteInfo(int id) {

        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            ticketingLogController.delete(id);
            System.out.println("삭제가 완료되었습니다.");
        }
    }
    
    public void updateFromViewer(int ticketId, int userId) {
    
        TicketingLogDTO t = new TicketingLogDTO();
        t.setTicketId(ticketId);
        t.setUserId(userId);
        ticketingLogController.add(t);
    }
    
    private int getTixId(int id) {
        ArrayList<TicketingLogDTO> list = ticketingLogController.selectAll();
        for(TicketingLogDTO t : list) {
           if(t.getTicketId() == id) {
               return t.getId();
           }
        }
        return 0;
    }

}
