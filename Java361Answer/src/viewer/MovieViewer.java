package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import model.UserDTO;
import model.MovieDTO;
import util.ScannerUtil;

public class MovieViewer {

    private RatingViewer ratingViewer;
    private ShowViewer showViewer;
    private TheaterViewer theaterViewer;
    private UserViewer userViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private MovieController movieController;

    public MovieViewer() {
        movieController = new MovieController();
    }

    public void setRatingViewer(RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
    }

    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }

    public void setTheaterViewer(TheaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void showMenu() {
        String message;
        if (logIn.getCategory() == 1) {
            showAdminMenu();
        } else {
            showGeneralMenu();
        }
    }

    private void showAdminMenu() {
        String message = "1. 영화 전체 목록 보기 2. 새로운 영화 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                insertMovie();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    private void showGeneralMenu() {
        String message = "1. 영화 전체 목록 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    private void insertMovie() {
        MovieDTO m = new MovieDTO();

        String message;
        message = "영화의 제목을 입력해주세요.";
        m.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "영화의 줄거리를 입력해주세요.";
        m.setSummary(ScannerUtil.nextLine(scanner, message));

        message = "영화의 등급을 입력해주세요. (1: 전체 2: 13세 3: 15세 4: 18세)";
        m.setGrade(ScannerUtil.nextInt(scanner, message, 1, 4));

        movieController.add(m);

    }

    private void printList() {
        ArrayList<MovieDTO> list = movieController.selectAll();
        if (list.isEmpty()) {
            System.out.println("아직 등록된 영화가 없습니다.");
        } else {
            for (MovieDTO m : list) {
                System.out.printf("%d. %s\n", m.getId(), m.getTitle());
            }
        }

        String message = "상세보기할 영화의 번호나 뒤로 가시려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        if (userChoice != 0) {
            printOne(userChoice);
        }
    }

    private void printOne(int id) {
        MovieDTO m = movieController.selectOne(id);
        System.out.println("\n=====================================");
        System.out.println("제목: " + m.getTitle());
        System.out.println("줄거리: " + m.getSummary());
        System.out.print("등급: ");
        switch (m.getGrade()) {
        case 1:
            System.out.println("전체 관람가");
            break;
        case 2:
            System.out.println("13세 이하 관람 불가");
            break;
        case 3:
            System.out.println("15세 이하 관람 불가");
            break;
        case 4:
            System.out.println("청소년 관람 불가");
            break;

        }
        System.out.println("=====================================\n");
        if (logIn.getCategory() == 1) {
            String message = "1. 영화 정보 수정 2. 영화 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateMovieInfo(id);
            } else if (userChoice == 2) {
                deleteMovieInfo(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            String message = "1. 평점 보기 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                ratingViewer.printAll(id, 0);
            } else if (userChoice == 2) {
                printList();
            }
        }
    }

    private void updateMovieInfo(int id) {
        MovieDTO m = movieController.selectOne(id);

        String message;

        message = "새로운 제목을 입력해주세요.";

        m.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "새로운 줄거리를 입력해주세요.";

        m.setSummary(ScannerUtil.nextLine(scanner, message));

        message = "새로운 등급을 입력해주세요.(1. 전체이용가 2. 13세 미만 관람불가 3. 15세 미만 관람불가 4. 청소년 관람불가";
        m.setGrade(ScannerUtil.nextInt(scanner, message));

        movieController.update(m);

    }

    private void deleteMovieInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            movieController.delete(id);
            showViewer.deleteShowByMovieid(id);
            printList();
        } else {
            printOne(id);
        }
    }

    public void printTitle(int id) {
        MovieDTO m = movieController.selectOne(id);
        System.out.print(m.getTitle());
    }

    public int selectMovieId() {
        ArrayList<MovieDTO> list = movieController.selectAll();

        for (MovieDTO m : list) {
            System.out.printf("%d. %s\n", m.getId(), m.getTitle());
        }

        String message = "등록할 영화의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        while (movieController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");

            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        return userChoice;
    }
    
}
