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
    
    public void setTicketViewer(TicketViewer ticketViewer) {
        this.ticketViewer = ticketViewer;
    }
    
    public void setTicketingLogViewer(TicketingLogViewer ticketingLogViewer) {
        this.ticketingLogViewer = ticketingLogViewer;
    }
    public void setRentCarViewer(RentCarViewer rentCarViewer) {
        this.rentCarViewer = rentCarViewer;
    }
    
    public void setRentCarLogViewer(RentCarLogViewer rentCarLogViewer) {
        this.rentCarLogViewer = rentCarLogViewer;
    }
    
    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }
    
    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }
    
    public void setBookingLogViewer(BookingLogViewer bookingLogViewer) {
        this.bookingLogViewer = bookingLogViewer;
    }

    // 선언테이블
    private UserController userController;
    private Scanner scanner;
    private TicketViewer ticketViewer;
    private TicketingLogViewer ticketingLogViewer;
    private RentCarViewer rentCarViewer;
    private RentCarLogViewer rentCarLogViewer;
    private HotelViewer hotelViewer;
    private HotelRoomViewer hotelRoomViewer;
    private BookingLogViewer bookingLogViewer;

    private UserDTO logIn;

    private final String userGrade1 = "일반 회원";
    private final String userGrade2 = "여행사용 등급";
    private final String userGrade3 = "관리자";

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showIndex() {
        String message = "1.로그인 (일반회원 u1 여행사용등급 u2 관리자 u3) 2. 회원가입 3. 종료";
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
            ticketViewer.setLogIn(logIn);
            ticketingLogViewer.setLogIn(logIn);
            
            
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
            message = "1.항공권 2.렌터카 3.호텔 4. 회원 정보 관리 5. 로그아웃";
        } else if (logIn.getUserGrade() == 2) {
            // 여행사용 등급일 경우
            message = "1.항공권 2.렌터카 3.호텔 4. 자신 정보 관리 5. 로그아웃";
        } else {
            // 일반회원의 경우
            message = "1.항공권 2.렌터카 3.호텔 4. 자신 정보 관리 5. 로그아웃";
        }

        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);

            if (userChoice == 1) {
                ticketViewer.showMenu();
            } else if (userChoice == 2) {
                //RentCarViewer.
            } else if (userChoice == 3) {
                //HotelViewer.
            } else if (userChoice == 4) {
                showUserMenu();
            } else if (userChoice == 5) {
                System.out.println("정상적으로 로그아웃 되었습니다.");
                logIn = null;
            }
        }

    }

    private void printOne(int id) {
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

    private void printSelectedUser(int id) {
        UserDTO u = userController.selectById(id);
        //print부분 UserDTO u 객체를 파라미터로받는 메소드로 분리 - 시간나면
        System.out.println("\n----------------------------------------");
        System.out.println(u.getUserName() + "회원님의 정보");
        System.out.println("==========================================");
        System.out.println("닉네임: " + u.getUserNickname());
        System.out.print("회원 등급: ");
        switch (u.getUserGrade()) {
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
        /*
        String message;
        int userChoice;
        message = "1. 유저 정보 변경 2. 유저 삭제 3. 돌아가기";
        userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
        } else if (userChoice == 2) {
            message = "정말로 해당 유저를 삭제하시겠습니까?";
            String yesNo = ScannerUtil.nextLine(scanner, message);
            if (yesNo.equalsIgnoreCase("Y")) {
                userController.delete(u.getId());
                
                System.out.println("정상적으로 삭제되었습니다.");
            }
        }
        */
    }
    
    private void updateUserByAdmin(int id) {
        UserDTO u = userController.selectById(id);
        printSelectedUser(id);
        String message;
        int userChoice;
        message = "1. 유저 정보 변경 2. 유저 삭제 3. 돌아가기";
        userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            
            message = "유저의 새 아이디를 입력하시오.";
            u.setUserName(ScannerUtil.nextLine(scanner, message));
            message = "유저의 새 비밀번호를 입력하시오.";
            u.setUserPassword(ScannerUtil.nextLine(scanner, message));
            message = "유저의 새 등급을 입력하시오 (1.일반회원 2.여행사 등급 3.관리자)";
            u.setUserGrade(ScannerUtil.nextInt(scanner, message, 1, 3));
            message = "유저의 새 닉네임을 입력하시오.";
            u.setUserNickname(ScannerUtil.nextLine(scanner, message));
            
            userController.update(u);
            
        } else if (userChoice == 2) {
            message = "정말로 해당 유저를 삭제하시겠습니까?";
            String yesNo = ScannerUtil.nextLine(scanner, message);
            if (yesNo.equalsIgnoreCase("Y")) {
                userController.delete(u.getId());
                System.out.println("정상적으로 삭제되었습니다.");
            }
        }
    }
    
    private void showUserMenu() {
        printOne(logIn.getId());
        int userChoice = 0;
        String message = "";
        if (logIn.getUserGrade() == 3) {//회원등급에 따른 선택지분리
            message = "1. 정보 수정 2. 탈퇴 3. 타 회원 정보변경 4. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateUserInfo();
            } else if (userChoice == 2) {
                deleteUserInfo();
            } else if (userChoice == 3) {
                message = "1. 회원 정보 수정 2. 신청자 등급 변경 3. 뒤로 가기";
                userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
                if (userChoice == 1) {
                    printAllUserInfo();
                    message = "정보를 수정할 회원을 선택하거나 0을 입력.";
                    userChoice = ScannerUtil.nextInt(scanner, message);
                    if (userChoice != 0) {
                        userController.selectById(userChoice);
                        //printSelectedUser(userChoice);
                        updateUserByAdmin(userChoice);
                    }
                } else if(userChoice == 2) {
                    ArrayList<UserDTO> alist = userController.filterByRequest();
                    if(alist.isEmpty()) {
                        System.out.println("\n 아직 요청이 존재하지 않습니다.");
                    }else {
                        System.out.println("신청자 목록입니다.\n");
                        for(UserDTO u : alist) {
                            //printSelectedUser(u.getId());
                            
                            setPromotion(u.getId());
                        }
                    }
                }
                
                
                /*
                else if (userChoice == 2) {
                    userController.filterByRequest(userChoice);

                    setPromotion(userChoice);
                    System.out.println("필요하지않은분기");
                }*/
                
            }
        } else if (logIn.getUserGrade() == 2) {
            message = "1. 정보 수정 2. 탈퇴 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                updateUserInfo();
            } else if (userChoice == 2) {
                deleteUserInfo();
            }

        } else if (logIn.getUserGrade() == 1) {
            message = "1. 정보 수정 2. 탈퇴 3. 등급 프로모션 신청 4. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if (userChoice == 1) {
                updateUserInfo();
            } else if (userChoice == 2) {
                deleteUserInfo();
            } else if (userChoice == 3) {
                if (logIn.getPromotionWating() == true) {
                    System.out.println("이미 신청하셨습니다.");
                } else {
                    logIn.setPromotionWating(true);
                    System.out.println("신청 완료.");
                    userController.update(logIn);
                }
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

        if (yesNo.equalsIgnoreCase("Y")) {
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
        for (UserDTO u : list) {
            System.out.printf("회원 ID: %s , 회원 비밀번호: %s , 회원 닉네임: %s, 회원 등급: %s\n", u.getUserName(), u.getUserPassword(),
                    u.getUserNickname(), u.getUserGrade());
        }
    }

    private void setPromotion(int id) {
        
        printSelectedUser(id);
        
        UserDTO u = userController.selectById(id);
        
        if (id != 0 && u.getPromotionWating() == true) {

            String message = "set promotion Yes or NO";
            String yesNo = ScannerUtil.nextLine(scanner, message);

            if (yesNo.equalsIgnoreCase("Y")) {

                System.out.printf("%s 는 이제 '여행사회원 등급' 입니다. \n", u.getUserNickname());
                u.setUserGrade(2);
                userController.update(u);
            }

        }else {
            System.out.println("에러체크");
            // 신청자 list 선출력방식으로 수정-시간나면
        }
    }
    /*
     * private ArrayList<UserDTO> filterByRequest(int userid) { ArrayList<UserDTO>
     * list = userController.selectAll(); ArrayList<UserDTO> temp = new
     * ArrayList<>(); for (UserDTO u : list) { if (u.getPromotionWating() == true) {
     * temp.add(u); } } return temp; }
     */
    
}
