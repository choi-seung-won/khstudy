package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.theaterController;
import controller.UserController;
import model.UserDTO;
import model.theaterDTO;
import util.ScannerUtil;

public class theaterViewer {

    private Scanner scanner;
    private UserDTO logIn;
    
    private UserViewer userViewer;
    private movieViewer movieViewer;
    private RateViewer rateViewer;
    
    private theaterController theaterController;

    // private 상영정보viewer

    public void setLogIn(UserDTO u) {
        if (u != null) {
            logIn = new UserDTO(u);
        } else {
            logIn = null;
        }
    }

    public theaterViewer() {
        
        theaterController = new theaterController();
        scanner = new Scanner(System.in);
    }
    
    public void setUserViewer(UserViewer userViewer) {this.userViewer = userViewer;}
    public void setMovieViewer(movieViewer movieViewer) {this.movieViewer = movieViewer;}
    public void setRateViewer(RateViewer rateViewer) {this.rateViewer = rateViewer;}
    


    public void showTheaterMenu() {

        ArrayList<theaterDTO> list = theaterController.selectAll();
        if (list.isEmpty()) {
            System.out.println("등록된 영화관이 아직 없습니다.");
        } else {

            for (theaterDTO t : list) {
                System.out.printf("%d번. 영화관 이름 : %s 영화관 위치 : %s\n", t.getId(), t.getName(), t.getLocation());
            }
            String message = "상세보기할 영화관의 변호 또는 뒤로가실경우 0 을 입력해주세요.";
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

        theaterDTO t = theaterController.selectOne(id);

        System.out.println("영화관 고유번호: " + t.getId());
        System.out.println("영화관 이름: " + t.getName());
        System.out.println("영화관 위치: " + t.getLocation());
        System.out.println("영화관 전화번호: " + t.getCallNum());// 정규표현식필요

        String message;
        int optionMin, optionMax;

        /*
        if (logIn.getUserRate().equals("관리자") || logIn.getUserRateCode() == 3) {
            
            System.out.println("WelcomeAdmin");
            
            message = "1. 새 영화관 등록 2. 이 영화관의 정보 수정 3. 이 영화관 삭제 4. 목록으로 가기";
            optionMin = 1;
            optionMax = 4;
            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
            if (userChoice == 1) {
                setNewTheaterObject();
            }else if(userChoice == 2) {
                update(id);
            }else if(userChoice == 3) {
                delete(id);
            }else if(userChoice == 4) {
                showTheaterMenu();
            }
            
        }
        else {
            
            
            
            
        }
        
        */
    }

    private void setNewTheaterObject() {

        theaterDTO t = new theaterDTO();
        String message;

        message = "영화관의 이름을 입력해주세요.";
        t.setName(ScannerUtil.nextLine(scanner, message));
        message = "영화관의 위치를 입력해주세요.";
        t.setLocation(ScannerUtil.nextLine(scanner, message));
        message = "영화관의 전화번호를 입력해주세요.";
        t.setCallNum(ScannerUtil.nextInt(scanner, message));

        theaterController.add(t);
    }

    private void update(int id) {

        theaterDTO t = theaterController.selectOne(id);
        String message;
        message = "영화관의 새로운 이름을 입력해주세요.";
        t.setName(ScannerUtil.nextLine(scanner, message));
        message = "영화관의 새로운 위치를 입력해주세요.";
        t.setLocation(ScannerUtil.nextLine(scanner, message));
        message = "영화관의 새로운 전화번호를 입력해주세요.";
        t.setCallNum(ScannerUtil.nextInt(scanner, message));

        theaterController.update(t);
        printOne(id);

    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            theaterController.delete(id);

            showTheaterMenu();
        } else {

            printOne(id);

        }

    }

}
