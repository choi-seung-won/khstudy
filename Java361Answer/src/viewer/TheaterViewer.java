package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.*;
import model.*;
import util.ScannerUtil;

public class TheaterViewer {

    private UserViewer userViewer;
    private MovieViewer movieViewer;
    private RatingViewer rateViewer;
    private ShowViewer showViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private TheaterController theaterController;

    public TheaterViewer() {
        theaterController = new TheaterController();
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void setRateViewer(RatingViewer rateViewer) {
        this.rateViewer = rateViewer;
    }

    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void showMenu() {
        if (logIn.getCategory() == 1) {
            showAdminMenu();
        } else {
            showGeneralMenu();
        }
    }

    private void showAdminMenu() {
        String message = "1. 극장 목록 보기 2. 극장 신규 등록 3. 뒤로가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("메인 메뉴로 이동합니다.");
                break;
            }
        }
    }

    private void add() {
        TheaterDTO t = new TheaterDTO();

        String message;
        message = "극장의 이름을 입력해주세요.";
        t.setName(ScannerUtil.nextLine(scanner, message));
        message = "극장의 주소를 입력해주세요.";
        t.setAddress(ScannerUtil.nextLine(scanner, message));
        message = "극장의 전화번호를 입력해주세요.";
        t.setPhoneNumber(ScannerUtil.nextLine(scanner, message));

        theaterController.add(t);
    }

    private void showGeneralMenu() {
        String message = "1.극장 목록 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                System.out.println("메인 메뉴로 이동.");
                break;
            }
        }

    }

    private void printAll() {
        ArrayList<TheaterDTO> list = theaterController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 극장이 없습니다.");

        } else {
            for (TheaterDTO t : list) {
                System.out.printf("%d. %s\n", t.getId(), t.getName());
            }

            String message = "상세보기할 극장의 번호나 뒤로 가실려면 0 을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && theaterController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    private void printOne(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        System.out.println("-------------------------------------");
        System.out.println("극장 이름: " + t.getName());
        System.out.println("극장 주소: " + t.getAddress());
        System.out.println("극장 전화번호: " + t.getPhoneNumber());
        System.out.println("-------------------------------------\n");

        if (logIn.getCategory() == 1) {
            String message = "1.극장 정보 수정 2. 극장 정보 삭제 3. 뒤로 가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                update(id);
            } else if (userChoice == 2) {
                delete(id);
            } else if (userChoice == 3) {
                printAll();
            }
        } else {
            String message = "1.뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 1);

            printAll();
        }
    }

    private void update(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        String message = "극장의 새로운 이름을 입력해주세요.";
        t.setName(ScannerUtil.nextLine(scanner, message));

        message = "극장의 새로운 주소를 입력해주세요.";
        t.setAddress(ScannerUtil.nextLine(scanner, message));

        message = "극장의 새로운 전화번호를 입력해주세요.";
        t.setPhoneNumber(ScannerUtil.nextLine(scanner, message));

        theaterController.update(t);
    }

    private void delete(int id) {
        String message = "해당 극장을 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            theaterController.delete(id);
            showViewer.deleteShowByTheaterId(id);
        } else {
            printOne(id);
        }
    }

    public void printName(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        System.out.print(t.getName());
    }

    public int selectId() {
        ArrayList<TheaterDTO> list = theaterController.selectAll();

        for (TheaterDTO t : list) {
            System.out.printf("%d. %s\n", t.getId(), t.getName());
        }

        String message = "상영할 극장의 번호를 입력해주세요.";

        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (theaterController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        return userChoice;
    }
    


}
