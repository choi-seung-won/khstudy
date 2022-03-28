package viewer;

import java.util.Scanner;
import java.util.ArrayList;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {

    // viewer추가시마다 초기화할 테이블
    public UserViewer() {
        userController = new UserController();
    }

    // 선언테이블
    private UserController userController;
    private Scanner scanner;

    private UserDTO logIn;

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
            // 연결할Viewer들의 setLogIn처리

            // movieViewer.setLogIn(logIn);
            // ratingViewer.setLogIn(logIn);
            // showViewer.setLogIn(logIn);
            // theaterViewer.setLogIn(logIn);
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

            UserDTO u = new UserDTO();
            u.setUserName(username);
            u.setUserPassword(password);
            u.setUserNickname(nickname);

            u.setUserGrade(1); // 일반회원 고정

            userController.add(u);

        }
    }

    private void showMenu() {
        String message;

        if (logIn.getUserGrade() == 3) {
            // 관리자일 경우
            message = "1.   2.   3.   4. 회원 정보 관리 5.  로그아웃";
        } else if (logIn.getUserGrade() == 2) {
            // 여행사용 등급일 경우
            message = "1.   2.  색 3.   4. 자신 정보 관리 5. 로그아웃";
        } else {
            // 일반회원의 경우
            message = "1. ";
        }

        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);

            if (userChoice == 1) {

            } else if (userChoice == 2) {

            } else if (userChoice == 3) {

            } else if (userChoice == 4) {

            } else if (userChoice == 5) {
                System.out.println("정상적으로 로그아웃 되었습니다.");
                logIn = null;
            }
        }

    }
    
    private void printOne() {
        System.out.println("\n----------------------------------------");
        System.out.println(logIn.getUserName() + "회원님의 정보");
        System.out.println("==========================================");
        System.out.println("닉네임: " + logIn.getUserNickname());
        System.out.println("회원 등급: ");
        switch (logIn.getUserGrade()) {
        case 1:
            System.out.println("일반 회원");
            break;
        case 2:
            System.out.println("여행사용 등급");
            break;
        case 3:
            System.out.println("관리자");
            break;
        }

        System.out.println("----------------------------------------\n");
    }

    private void showUserMenu() {
        printOne();
        int userChoice = 0;
        String message = "";
        if (logIn.getUserGrade() == 3) {
            message = "1. 정보 수정 2. 탈퇴 3. 타 회원 정보변경 4. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateUserInfo();
            } else if (userChoice == 2) {
                deleteUserInfo();
            } else if (userChoice == 3) {
                printAllUserInfo();
                message = "1. 회원 정보 수정 2. 신청자 등급 변경 3. 뒤로 가기";
                userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
                if(userChoice == 1) {
                    message = "정보를 수정할 회원을 선택하거나 0을 입력.";
                    userChoice = ScannerUtil.nextInt(scanner, message);
                    if(userChoice != 0) {
                        setPromotion(userChoice);
                    }
                }else if(userChoice == 2) {
                    
                }
            }
        } else {
            message = "1. 정보 수정 2. 탈퇴 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                updateUserInfo();
            } else if (userChoice == 2) {
                deleteUserInfo();
            }

        }
    }

    private void updateUserInfo() {
        UserDTO u = new UserDTO(logIn);

        String message = "사용하실 닉네임을 입력해주세요.";

        u.setUserNickname(ScannerUtil.nextLine(scanner, message));

        message = "사용하실 비밀번호를 입력해주세요.";

        u.setUserPassword(ScannerUtil.nextLine(scanner, message));

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

    public int selectGradeById(int id) {
        return userController.selectOne(id).getUserGrade();
    }
    
    private void printAllUserInfo() {
        
        ArrayList<UserDTO> list = userController.selectAll();
        for(UserDTO u : list) {
            System.out.printf("회원 ID: %s , 회원 비밀번호: %s , 회원 닉네임: %s, 회원 등급: %s", 
                    u.getUserName(),u.getUserPassword(),u.getUserNickname(),u.getUserGrade());
        }
        
    }
    
    private void setPromotion(int id) {
        UserDTO u = new UserDTO();
        if(id != 0) {
            
            String message = "promotion YesorNO";
            String yesNo = ScannerUtil.nextLine(scanner, message);
            
            if(yesNo.equalsIgnoreCase("Y")) {
                
            }
            
        }
    }

}
