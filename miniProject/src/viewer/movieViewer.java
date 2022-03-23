package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.UserController;
import controller.movieController;
import model.UserDTO;
import model.movieDTO;
import util.ScannerUtil;

public class movieViewer {

    private Scanner scanner;
    private UserDTO logIn;
    private UserViewer userViewer;
    private movieController movieController;
    private RateViewer rateViewer;
    private theaterViewer TheaterViewer;
    
    
    private final int MOVIE_RATE_CODE_MIN = 1;
    private final int MOVIE_RATE_CODE_MAX = 3;

    public void setLogIn(UserDTO u) {
        if (u != null) {
            logIn = new UserDTO(u);
        }

        else {
            logIn = null;
        }
    }

    public void setUserViewer(UserViewer userViewer) {

        this.userViewer = userViewer;
        rateViewer.setUserViewer(userViewer);
        TheaterViewer.setUserViewer(userViewer);
        
    }

    public void setRateViewer(RateViewer rateViewer) {
        this.rateViewer = rateViewer;
    }
    
    public void setTheaterViewer(theaterViewer theaterViewer) {
        this.TheaterViewer = theaterViewer;
    }

    public movieViewer() {

        movieController = new movieController();
        scanner = new Scanner(System.in);

    }

    public void showMenu() {

        String message = "1. 영화 목록 보기 2. 극장 목록 보기 3. 상영 정보 보기 4. 프로그램 종료";

        while (true) {

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

            if (userChoice == 1) {
                showMovieMenu();
            } else if (userChoice == 2) {
                TheaterViewer.showTheaterMenu();
            } else if (userChoice == 3) {

            } else if (userChoice == 4) {

                System.out.println("thanks for use");
                break;
            }
        }

    }

    private void showMovieMenu() {

        ArrayList<movieDTO> list = movieController.selectAll();
        if (list.isEmpty()) {

            System.out.println("등록된 영화가 아직 없습니다. ");
        } else {

            for (movieDTO m : list) {

                System.out.printf("%d번. 영화 이름 : %s\n", m.getId(), m.getName());

            }
            String message = "상세보기할 영화의 번호를 입력 또는 뒤로가는걸 희망하실경우 0을 입력하시오.";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
            if (userChoice != 0) {
                printOne(userChoice);
            }

        }

    }

    private void printOne(int id) {

        // UserDTO u = new UserDTO();
        // UserViewer uv = new UserViewer();
        
        
        movieDTO m = movieController.selectOne(id);

        System.out.println("영화 고유번호: " + m.getId());
        System.out.println("제목: " + m.getName());
        System.out.println("영화의 등급: " + m.getMovieRate());
        System.out.println("영화의 줄거리: " + m.getPlot());

        
        String message;
        int optionMin, optionMax;
        
        

        if (logIn.getUserRate().equals("관리자") || logIn.getUserRateCode() == 3) { 
            // 유저정보 수정시 반영X

            System.out.println("YouAreVerifiedUser");

            message = "1. 새 영화 등록 2. 이 영화의 정보 수정 3. 이 영화 삭제 4. 목록으로 가기";
            optionMin = 1;
            optionMax = 4;
            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
            if (userChoice == 1) {

                setNewMovieObject();

            } else if (userChoice == 2) {

                update(id);

            } else if (userChoice == 3) {

                delete(id);

            } else if (userChoice == 4) {

                showMovieMenu();

            }
        }

        else {

            message = "1. 평론 작성 2. 이 영화의 전체평점 보기 3. 이 영화의 평론가 평점 보기 4. 이 영화의 일반관람객 평점 보기 5. 목록으로 가기";
            optionMin = 1;
            optionMax = 5;

            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);

            if (userChoice == 1) {
                rateViewer.writeReply(logIn.getId(), id);
                printOne(id);
            } else if (userChoice == 2) {
                rateViewer.printList(id);
            } else if (userChoice == 3) {
                // 전문가(rateCode==2) 평점
                rateViewer.printSelectedList(id);
            } else if (userChoice == 4) {
                // 일반 관람객 평점

            } else if (userChoice == 5) {

                showMovieMenu();
            }
        }

    }

    private void setNewMovieObject() {

        movieDTO m = new movieDTO();
        String message;

        message = "영화의 제목을 입력해주세요.";

        m.setName(ScannerUtil.nextLine(scanner, message));

        message = "영화의 등급을 입력해주세요.(1 = 전체이용가. 2 = 15세 이상 이용가. 3 = 청소년 관람불가.)";
        m.setMovieRateCode(ScannerUtil.nextInt(scanner, message, MOVIE_RATE_CODE_MIN, MOVIE_RATE_CODE_MAX));

        message = "영화의 줄거리를 입력해주세요.";

        m.setPlot(ScannerUtil.nextLine(scanner, message));
        
        movieController.add(m);

    }

    private void update(int id) {

        movieDTO m = movieController.selectOne(id);
        String message;

        message = "새로운 제목을 입력해주세요.";
        m.setName(ScannerUtil.nextLine(scanner, message));
        message = "새로운 Plot을 입력해주세요.";
        m.setPlot(ScannerUtil.nextLine(scanner, message));
        message = "새로운 영화등급을 입력해주세요.(1 = 전체이용가. 2 = 15세 이상 이용가. 3 = 청소년 관람불가.)";
        m.setMovieRateCode(ScannerUtil.nextInt(scanner, message, MOVIE_RATE_CODE_MIN, MOVIE_RATE_CODE_MAX));

        movieController.update(m);
        printOne(id);

    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {

            movieController.delete(id);

            showMovieMenu();
        } else {

            printOne(id);
        }
    }

}
