package homework;

import java.util.*;

import util.ScannerUtil;

public class Ex07User {

    // 회원을 관리하는 프로그램을 작성하세요
    // 회원에게 필요한 정보: 사용자 번호, 로그인용 아이디(=username) , 로그인용 비밀번호, 닉네임
    // 필요한기능:로그인(=인덱스화면), 메뉴화면 보기(1. 정보보기 2.로그아웃), 회원정보수정 및 탈퇴
    // 단, 회원 정보 수정시에는 비밀번호와 닉네임만 수정 가능하고 수정을 완료하기 전에는
    // 비밀번호를 입력받아 기존 비밀번호와 일치할때에만 수정이 완료되게 하시오
    // 전역 변수
    // 1. 입력을 처리할 Scanner 클래스 변수
    private static Scanner scanner;
    // 2. 게시글을 저장할 Board클래스배열
    private static ArrayList<User> list;
    private static int nextId;
    private static User logIn;

    // 1. init();
    private static void init() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        nextId = 1;
        
        showIndex();
        
    }

    // 2. showIndex();
    private static void showIndex() {
        while (true) {
            String message = "1. 로그인 2. 회원가입 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                logIn();
                if (logIn != null) {
                    showMenu();
                }
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("exitprogram");
                break;
            }
        }
    }

    // 3. logIn();
    private static void logIn() {

        String usernameMessage = "유저네임 입력";
        String username = ScannerUtil.nextLine(scanner, usernameMessage);

        String passwordMessage = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, passwordMessage);

        logIn = auth(username, password);

        while (logIn == null) {
            System.out.println("유저네임 혹은 비밀번호가 일치하지 않습니다.");

            String message = "인덱스로 돌아가시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(scanner, message);
            if (yesNo.equalsIgnoreCase("N")) {
                break;
            }
            username = ScannerUtil.nextLine(scanner, usernameMessage);
            password = ScannerUtil.nextLine(scanner, passwordMessage);

            logIn = auth(username, password);
        }
    }

    // 4. auth();
    private static User auth(String username, String password) {
        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }

        return null;
    }

    // 5. register()
    private static void register() {
        String message = "사용하실 유저네임 입력 또는 뒤로가는경우 X를입력";
        String username = ScannerUtil.nextLine(scanner, message);

        while (validateUsername(username) && !username.equalsIgnoreCase("X")) {

            System.out.println("중복된 회원 유저네임 입니다.");
            username = ScannerUtil.nextLine(scanner, message);

        }

        if (!username.equalsIgnoreCase("X")) {
            message = "사용하실 비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, message);
            message = "사용하실 닉네임을 입력해주세요.";
            String nickname = ScannerUtil.nextLine(scanner, message);

            User u = new User();

            u.setId(nextId++);
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);

            list.add(u);

            System.out.println("회원가입이 되었습니다.");
            System.out.println("유저네임과 비밀번호로 로그인 해주세요.");

            showIndex();
        }

    }

    // 6. validateUsername();
    private static boolean validateUsername(String username) {
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    // 7. showMenu();
    private static void showMenu() {
        while (true) {
            String message = "1. 회원정보보기 2. 로그아웃";

            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {

                printOne(logIn.getId());

            } else if (userChoice == 2) {

                System.out.println("정상적으로 로그아웃되셨습니다.");

                logIn = null;

                break;
            }
        }
    }

    // 8. printOne();
    private static void printOne(int id) {
        User u = selectOneById(id);
        u.printInfo();
        String message = "1. 수정 2. 탈퇴 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if(userChoice == 1) {
            
            update(id);
            
            
        }else if(userChoice == 2) {
            delete(id);
            
        }
        
        
    }

    
    // 7.updae();
    
    private static void update(int id) {
        String message;
        message = "새로운 비밀번호를 입력해주세요.";
        String newPassword = ScannerUtil.nextLine(scanner , message);
        message = "새로운 닉네임을 입력해주세요.";
        String newNickname = ScannerUtil.nextLine(scanner,message);
        message = "기존 비밀번호를 입력해주세요.";
        String oldPassword = ScannerUtil.nextLine(scanner,message);
        
        User u =selectOneById(id);
        if(u.getPassword().equals(oldPassword)) {
            
            u.setPassword(newPassword);
            u.setNickname(newNickname);
            
        }
        
    }
    
    // 8. delete();
    private static void delete(int id) {
        String message = "정말로 탈퇴하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner,message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            User u = new User();
            u.setId(id);
            list.remove(u);
            
            System.out.println("회원 탈퇴가 성공적으로 진행되어 인덱스 화면으로 돌아갑니다.");
            logIn = null;
        }
    }
    // 9. selectOneById()
    private static User selectOneById(int id) {
        User u = new User();
        u.setId(id);;
        if(list.contains(u)) {
            return list.get(list.indexOf(u));
        }
        
        
        return null;
    }
    // 9. delete();
    
    public static void main(String[] args) {
        init();
    }

}
