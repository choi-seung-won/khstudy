package viewer;

import java.util.Scanner;

import controller.ShowController;
import model.ShowDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;

public class ShowViewer {

    private MovieViewer movieViewer;
    private RatingViewer ratingViewer;
    private TheaterViewer theaterViewer;
    private UserViewer userViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private ShowController showController;

    public ShowViewer() {
        showController = new ShowController();
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void setRatingViewer(RatingViewer ratingViewer) {
        this.ratingViewer = ratingViewer;
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
        if (logIn.getCategory() == 1) {
            showAdminMenu();

        } else {
            showGeneralMenu();
        }
    }

    private void showAdminMenu() {
        String message = "1. 전체 상영 정보 보기 2. 신규 상영 정보 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("뒤로 돌아갑니다.");
                break;

            }
        }
    }

    private void showGeneralMenu() {
        String message = "1. 상영 정보 목록 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }

        }
    }

    private void printAll() {
        ArrayList<ShowDTO> list = showController.selectAll();

        for (ShowDTO s : list) {
            System.out.printf("%d. ", s.getId());
            movieViewer.printTitle(s.getMovieId());
            System.out.print(" at ");
            theaterViewer.printName(s.getTheaterId());
            System.out.printf(" (%s) \n", s.getShowTime());
        }
    }

    private void add() {

        ShowDTO s = new ShowDTO();

        s.setMovieId(movieViewer.selectMovieId());

        s.setTheaterId(theaterViewer.selectId());

        String message = "상영 시간을 입력해주세요.";
        s.setShowTime(ScannerUtil.nextLine(scanner, message));

        showController.add(s);

    }
    
    public void deleteShowByTheaterId(int theaterId) {
        showController.deleteByTheaterId(theaterId);
    }
    
    public void deleteShowByMovieid(int movieId) {
        showController.deleteByMovieId(movieId);
    }

}
