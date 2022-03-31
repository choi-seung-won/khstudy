package viewer;

import java.util.*;
import model.*;
import util.ScannerUtil;
import controller.TicketController;

public class TicketViewer {

    private Scanner scanner;

    private UserDTO logIn;
    private UserViewer userViewer;
    private TicketingLogViewer ticketingLogViewer;

    private TicketController ticketController;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setTicketingLogViewer(TicketingLogViewer ticketingLogViewer) {
        this.ticketingLogViewer = ticketingLogViewer;
    }

    public TicketViewer() {
        ticketController = new TicketController();
    }

    public void showMenu() {// admin구분필요 x? 필요할수있음
        
            //ticketingLogViewer.updateLog(logIn.getId());// 중복호출시객체값중복
        
        String message = "1. 항공권 보기 2. 항공권 예매기록 보기 3. 뒤로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            showTicketMenu();
        } else if (userChoice == 2) {
            // ticketingLogViewer.updateLogTest();//중복실행없이연동
            // ticketingLogViewer.setReservedTicket();
            // ticketingLogViewer.printAll(logIn.getId());
            ticketingLogViewer.printSetValue();
        } else if (userChoice == 3) {

        }

    }

    private void showTicketMenu() {
        String message = "";
        int userChoice;
        if (logIn.getUserGrade() == 3) { // 어드민
            System.out.println("welcome admin");
            message = "1. 항공권 목록 보기 2. 새로운 항공권 등록 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                addNewTicket();
            }
        } else if (logIn.getUserGrade() == 2) {
            message = "1. 항공권 목록 보기 2. 새로운 항공권 등록 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                addNewTicket();
            }
        } else if (logIn.getUserGrade() == 1) {
            printList();
        }
    }

    private void printList() {
        ArrayList<TicketDTO> list = ticketController.filterByReserved();
        if (list.isEmpty()) {
            System.out.println("여행편이 없습니다.");
        } else if (logIn.getUserGrade() == 3) {// 관리자
            list = ticketController.selectAll();
            for (TicketDTO t : list) {
                System.out.printf("티켓 id : %d ,출발지: %s , 도착지: %s , 좌석: %s , 출발시간: %s , 도착시간: %s\n", t.getId(),
                        t.getDeparture(), t.getDestination(), t.getSeat(), t.getDepartureTime(), t.getArrivalTime());
            }
        } else {
            for (TicketDTO t : list) {
                System.out.printf("티켓 id : %d ,출발지: %s , 도착지: %s , 좌석: %s , 출발시간: %s , 도착시간: %s\n", t.getId(),
                        t.getDeparture(), t.getDestination(), t.getSeat(), t.getDepartureTime(), t.getArrivalTime());
            }
        }

        String message = "상세보기할 항공권의 번호 또는 뒤로가시려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        while (userChoice != 0 && ticketController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        if (logIn.getUserGrade() == 1 && ticketController.filterByReserved(userChoice) == true) {
            // 에러-해결
            System.out.println("이미 예약된 항목입니다.");
        } else if (userChoice != 0) {
            printOne(userChoice);
        }
    }

    private void printOne(int id) {
        TicketDTO t = ticketController.selectOne(id);
        System.out.printf("티켓 id: %d, 출발지: %s , 도착지: %s , 좌석: %s , 출발시간: %s , 도착시간: %s\n", t.getId(), t.getDeparture(),
                t.getDestination(), t.getSeat(), t.getDepartureTime(), t.getArrivalTime());
        String message = "";
        int userChoice = 0;
        if (logIn.getUserGrade() == 3) {
            message = "1. 해당 항공권 정보 수정 2. 해당 항공권 삭제 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            updateAndDelete(userChoice, id);
        } else if (logIn.getUserGrade() == 2) {
            message = "1. 해당 항공권 정보 수정 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            updateAndDelete(userChoice, id);
        } else if (logIn.getUserGrade() == 1 && t.getReserved() == false) {

            message = "1. 해당 항공권 예약 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            if (userChoice == 1) {
                if (t.getReserved() == true) {
                    System.out.println("티켓에러처리");
                } else {
                    t.setReserved(true);
                    t.setReservedUserId(logIn.getId());
                    ticketController.update(t);
                    ticketingLogViewer.updateFromViewer(t.getId(), logIn.getId());
                    System.out.println("예약이 완료되었습니다.");
                }
            }
        }
    }

    private void updateTicketInfo(int id) {
        TicketDTO t = ticketController.selectOne(id);

        String message = "티켓의 새 출발지를 입력하시오.";
        t.setDeparture(ScannerUtil.nextLine(scanner, message));
        message = "도착지를 입력하시오.";// 차후 regular_expression으로 타입형식제한
        t.setDestination(ScannerUtil.nextLine(scanner, message));
        message = "출발시간을 입력하시오.";
        t.setDepartureTime(ScannerUtil.nextLine(scanner, message));
        message = "도착시간을 입력하시오.";
        t.setArrivalTime(ScannerUtil.nextLine(scanner, message));
        message = "좌석을 입력하시오.";
        t.setSeat(ScannerUtil.nextLine(scanner, message));

        ticketController.update(t);

    }

    private void deleteTicketInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            ticketController.delete(id);
            // 기타viewer연동사항 삭제
            printList();
        } else {
            printOne(id);
        }
    }

    private void updateAndDelete(int userChoice, int ticketId) {
        if (userChoice == 1) {
            updateTicketInfo(ticketId);
        } else if (userChoice == 2 && logIn.getUserGrade() == 3) {
            deleteTicketInfo(ticketId);
        }
    }

    private void addNewTicket() {
        TicketDTO t = new TicketDTO();

        String message = "새 티켓의 출발지를 입력하시오.";
        t.setDeparture(ScannerUtil.nextLine(scanner, message));
        message = "도착지를 입력하시오.";
        t.setDestination(ScannerUtil.nextLine(scanner, message));
        message = "출발시간을 입력하시오.";
        t.setDepartureTime(ScannerUtil.nextLine(scanner, message));
        message = "도착시간을 입력하시오.";
        t.setArrivalTime(ScannerUtil.nextLine(scanner, message));
        message = "좌석을 입력하시오.";
        t.setSeat(ScannerUtil.nextLine(scanner, message));

        ticketController.add(t);

    }

    public int selectReservedId(int id) {
        if (ticketController.selectOne(id).getReservedUserId() != 0) {
            return ticketController.selectOne(id).getReservedUserId();
        } else {
            return 0;
        }
    }

    // selectAll에서reservedId를긁어와야함. logDTO와 datatype이다르므로 .getReserved~로추출?
    public ArrayList<TicketDTO> selectReservedTicket(int id) {
        return ticketController.selectReservedTicket();
    }

    public int setTemp(int id) {
        ArrayList<TicketDTO> list = new ArrayList<>();
        list = selectReservedTicket(id);
        for (TicketDTO t : list) {
            if (t.getReserved() != false) {
                return t.getId();
            }
        }
        return 0;
    }

    public int returnUserId(int id) {
        return ticketController.returnUserId(id);
    }

    public int returnTicketId(int id) {// logIn.getid를파라미터로
        return ticketController.returnTicketId(id);
    }

    public int getSizeofTicketArray() {
        return ticketController.returnsize();
    }

    public ArrayList<TicketDTO> setTicketId() {
        ArrayList<TicketDTO> list = ticketController.selectAll();
        ArrayList<TicketDTO> temp = new ArrayList<TicketDTO>();
        
        for (TicketDTO t : list) {
            if(t.getReservedUserId() == logIn.getId()) {
                temp.add(new TicketDTO(t));
            }
        }
        return temp;
    }
    
    /*
    public int getTicketId(int id) {
        
        ArrayList<TicketDTO> list = setTicketId();
        for(TicketDTO t : list) {
            if(t.getReservedUserId() == ticketingLogViewer.) {
                return t.getId();
            }
        }
        
    }
    */

    public int getReserverdTicketSize(){
        ArrayList<TicketDTO> list = ticketController.selectAll();
        ArrayList<TicketDTO> temp = new ArrayList<TicketDTO>();
        for(TicketDTO t : list) {
            if(t.getReservedUserId() != 0) {
                temp.add(new TicketDTO(t));
            }
        }
        return temp.size();
    }
    
}
