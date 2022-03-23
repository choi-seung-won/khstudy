package viewer;

import java.util.Scanner;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

// TODO : SHOWMENU 수정

public class UserViewer {

    private final int RATE_CODE1 = 1;
    private final int RATE_CODE2 = 2;
    private final int RATE_CODE3 = 3;

    private final String OPTION_GO_BACK = "X";
    private Scanner scanner;
    private UserController userController;
    private UserDTO logIn;

    private movieViewer movieViewer;
    private RateViewer rateViewer;
    private theaterViewer theaterViewer;
    
    public UserViewer() {
        
        scanner = new Scanner(System.in);
        userController = new UserController();
        rateViewer = new RateViewer();
        movieViewer = new movieViewer();
        movieViewer.setRateViewer(rateViewer);
        //movieViewer.setUserViewer(this);
        
        theaterViewer = new theaterViewer();
        //theaterViewer.setUserViewer(this);
        theaterViewer.setRateViewer(rateViewer);
        

    }

    public void showIndex() {
        String message = "1.로그인 2.회원가입 3. 종료";
        while (true) {

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                logIn();

                if (logIn != null) {
                    System.out.println("로그인 성공.");
                    showMenu();
                }

            } else if (userChoice == 2) {

                register();

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다 .");
                break;
            }
        }

    }

    private void register() {
        String message;

        message = "사용하실 아이디를 입력 또는 뒤로 가실경우 X를 입력.";
        String username = ScannerUtil.nextLine(scanner, message);

        while (userController.validateUsername(username)) {

            System.out.println("사용하실 수 없는 아이디입니다.");
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase(OPTION_GO_BACK)) {
                break;
            }
        }
        if (!username.equalsIgnoreCase(OPTION_GO_BACK)) {

            message = "사용할 비밀번호를 입력.";
            String password = ScannerUtil.nextLine(scanner, message);
            message = "사용할 닉네임을 입력. ";
            String nickname = ScannerUtil.nextLine(scanner, message);
            message = "계정의 등급을 입력.";
            int accountRank = ScannerUtil.nextInt(scanner, message, RATE_CODE1, RATE_CODE3);

            UserDTO u = new UserDTO();
            u.setUserName(username);
            u.setUserPassword(password);
            u.setNickname(nickname);
            u.setUserRateCode(accountRank);

            userController.add(u);

        }

    }

    private void logIn() {

        String message;
        message = "아이디를 입력";

        String username = ScannerUtil.nextLine(scanner, message);
        message = "비밀번호를 입력";
        String password = ScannerUtil.nextLine(scanner, message);
        while (userController.auth(username, password) == null) {
            System.out.println("잘못입력했거나 존재하지 않는 유저입니다.");
            message = "아이디를 입력하거나 뒤로갈경우 X를입력";
            username = ScannerUtil.nextLine(scanner, message);
            if (username.equalsIgnoreCase(OPTION_GO_BACK)) {

                break;
            }
            message = "비밀번호를 입력하시오.";
            password = ScannerUtil.nextLine(scanner, message);
        }

        logIn = userController.auth(username, password);

    }

    public void setLogIn(UserDTO u) {
        logIn = new UserDTO(u);
    }

    private void printOne(int id) {

        UserDTO temp = userController.selectOne(id);

        System.out.println(temp.getNickname() + "회원님의 정보");
        System.out.println("아이디: " + temp.getUserName());
        System.out.println("닉네임: " + temp.getNickname());
        // System.out.println("계정 등급: " + temp.getUserRate());
        // System.out.println("계정 등급: " + convertRateCode(temp.getUserRateCode()));
        System.out.println("계정 등급: " + temp.getUserRate());
        String message = "1.수정 2.회원탈퇴 3.뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        }

    }

    private void update(int id) {
        String message;
        UserDTO u = userController.selectOne(id);

        message = "수정할 닉네임을 입력";
        u.setNickname(ScannerUtil.nextLine(scanner, message));
        message = "수정할 비밀번호를 입력";
        u.setUserPassword(ScannerUtil.nextLine(scanner, message));
        message = "계정 등급 수정 (1. 일반관람객 2. 전문평론가 3. 관리자)";
        u.setUserRateCode(ScannerUtil.nextInt(scanner, message, RATE_CODE1, RATE_CODE3));
        message = "기존 비밀번호를 다시 입력";
        String oldPassword = ScannerUtil.nextLine(scanner, message);

        if (logIn.getUserPassword().equals(oldPassword)) {
            userController.update(u);
        }
        printOne(id);
    }

    private void delete(int id) {
        String message = "정말로 탈퇴하시겠습니까?";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            userController.delete(id);
            rateViewer.deleteByWriterId(id);
            /*
             * boardViewer.deleteByWriterId(id);
             */
            logIn = null;
        } else {
            printOne(id);

        }

    }

    public void printNickname(int id) {

        UserDTO u = userController.selectOne(id);
        System.out.print(u.getNickname());
    }

    public boolean verifyUser(int id) {
        UserDTO u = userController.selectOne(id);

        if (u.getUserRateCode() == 3) {
            System.out.println("관리자입니다.");
            return true;
        }
        return false;

    }

    private void showMenu() {

        String message = "1. 영화 게시판 이동 2. 회원 정보 보기 3. 극장 목록보기 4.극장 개별보기 5. 로그아웃";
        while (logIn != null) {

            movieViewer.setLogIn(logIn);

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
            if (userChoice == 1) {
                movieViewer.showMenu();
            } else if (userChoice == 2) {
                printOne(logIn.getId());
            } else if (userChoice == 3) {
                //극장목록보기
                theaterViewer.showTheaterMenu();
            } else if (userChoice == 4) {
                //극장개별보기
            } else if (userChoice == 5) {
                System.out.println("로그아웃 되셨습니다.");
                logIn = null;
                
                movieViewer.setLogIn(null);//
                theaterViewer.setLogIn(null);
            }

        }
    }

}
