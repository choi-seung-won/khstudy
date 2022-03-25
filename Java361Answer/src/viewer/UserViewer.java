package viewer;

import java.util.Scanner;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void setRatingViewer(RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
    }

    public void setTheaterViewer(TheaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
    }

    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }

    public UserViewer() {
        userController = new UserController();
    }

    private MovieViewer movieViewer;
    private RatingViewer ratingViewer;
    private TheaterViewer theaterViewer;
    private ShowViewer showViewer;
    private Scanner scanner;

    private UserController userController;
    private UserDTO logIn;// privatevoid logIn의 auth를 체크했을경우 넘겨지는 data기록

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }

    public void showIndex() {
        String message = "1.로그인 2. 회원가입 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {

                logIn();

                if (logIn != null) {
                    showMenu();
                }
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void logIn() {
        String usernameMsg = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, usernameMsg);

        String passwordMsg = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, passwordMsg);

        while (userController.auth(username, password) == null) {
            System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
            usernameMsg = "아이디나 뒤로 가실려면 \"x\"를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, usernameMsg);

            if (username.equalsIgnoreCase("X")) {
                break;
            }

            password = ScannerUtil.nextLine(scanner, password);
        }

        logIn = userController.auth(username, password);
        if (logIn != null) {
            movieViewer.setLogIn(logIn);
            ratingViewer.setLogIn(logIn);
            showViewer.setLogIn(logIn);
            theaterViewer.setLogIn(logIn);
        }
    }

    private void register() {
        String usernameMsg = "사용하실 아이디나 뒤로 가실려면 \"X\"를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, usernameMsg);

        while (userController.validateUsername(username) && !username.equalsIgnoreCase("X")) {
            System.out.println("잘못 입력하셨습니다.");
            username = ScannerUtil.nextLine(scanner, usernameMsg);

        }

        if (!username.equalsIgnoreCase("X")) {

            String passwordMsg = "사용하실 비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, passwordMsg);
            String nicknameMsg = "사용하실 닉네임을 입력해주세요.";
            String nickname = ScannerUtil.nextLine(scanner, nicknameMsg);
            String categoryMsg = "회원 유형을 입력해주세요.(1. 관리자 2. 평론가 3. 일반회원)";
            int category = ScannerUtil.nextInt(scanner, categoryMsg, 1, 3);

            UserDTO u = new UserDTO();
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);
            u.setCategory(category);

            userController.add(u);

        }

    }

    private void showMenu() {
        String message;

        if (logIn.getCategory() == 1) {
            // 관리자일 경우
            message = "1. 영화 관리 2. 극장 관리 3. 상영 정보 관리 4. 회원 정보 관리 5.  로그아웃";
        } else {
            // 그외일경우
            message = "1. 영화 정보 검색 2. 극장 정보 검색 3. 상영 정보 검색 4. 회원 정보 관리 5. 로그아웃";
        }

        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                movieViewer.showMenu();
            } else if (userChoice == 2) {

            } else if (userChoice == 3) {

            } else if (userChoice == 4) {
                showUserMenu();
            } else if (userChoice == 5) {
                System.out.println("정상적으로 로그아웃 되었습니다.");
                logIn = null;
            }
        }

    }

    private void showUserMenu() {
        printOne();

        String message = "1. 정보 수정 2. 탈퇴 3. 뒤로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            updateUserInfo();
        } else if (userChoice == 2) {
            deleteUserInfo();
        }

    }

    private void printOne() {
        System.out.println("\n----------------------------------------");
        System.out.println(logIn.getUsername() + "회원님의 정보");
        System.out.println("==========================================");
        System.out.println("닉네임: " + logIn.getNickname());
        System.out.println("회원 등급: ");
        switch (logIn.getCategory()) {
        case 1:
            System.out.println("관리자");
            break;
        case 2:
            System.out.println("전문 평론가");
            break;
        case 3:
            System.out.println("일반 회원");
            break;
        }

        System.out.println("----------------------------------------\n");
    }

    private void updateUserInfo() {
        UserDTO u = new UserDTO(logIn);

        String message = "사용하실 닉네임을 입력해주세요.";
        u.setNickname(ScannerUtil.nextLine(scanner, message));

        message = "사용하실 비밀번호를 입력해주세요.";

        u.setPassword(ScannerUtil.nextLine(scanner, message));

        userController.update(u);

        logIn = u;
        
        showUserMenu();

    }

    private void deleteUserInfo() {

        String message = "정말로 탈퇴하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("X")) {
            userController.delete(logIn.getId());
            logIn = null;
        } else {
            showUserMenu();
        }
    }
    public void printNickname(int id) {
        UserDTO u = userController.selectOne(id);
        System.out.print(u.getNickname());
        
    }
    
    public int selectCategoryById(int id) {
        return userController.selectOne(id).getCategory();
    }

}
