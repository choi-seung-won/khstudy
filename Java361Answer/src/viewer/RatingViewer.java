package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

import controller.RatingController;
import model.RatingDTO;
import model.UserDTO;
import util.ScannerUtil;

public class RatingViewer {

    private MovieViewer movieViewer;
    private ShowViewer showViewer;
    private TheaterViewer theaterViewer;
    private UserViewer userViewer;
    private Scanner scanner;
    private UserDTO logIn;
    private RatingController ratingController;

    public RatingViewer() {
        ratingController = new RatingController();
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
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

    public void printAll(int movieId, int category) {
        ArrayList<RatingDTO> list;
        if (category == 0) {
            list = ratingController.selectAll(movieId);
        } else {
            list = filterByCategory(movieId, category);
        }
        printList(list);

        String message;
        int userChoice = 0;

        if (list.isEmpty()) {
            message = "1. 신규 평점 등록 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                writeRating(movieId);
                printAll(movieId, 0);
            }
        } else {
            if (category == 0) {
                message = "1. 전문가 평점 보기 2. 일반 회원 평점 보기 3. 신규 평점 등록 4. 뒤로 가기";
                userChoice = ScannerUtil.nextInt(scanner, message);

                if (userChoice == 1) {
                    printAll(movieId, 2);
                } else if (userChoice == 2) {
                    printAll(movieId, 3);
                }
            } else if (category == 2) {
                message = "1. 전체 평점 보기 2. 일반 회원 평점 보기 3. 신규 평점 등록 4. 뒤로 가기";
                userChoice = ScannerUtil.nextInt(scanner, message);

                if (userChoice == 1) {
                    printAll(movieId, 0);
                } else if (userChoice == 2) {
                    printAll(movieId, 3);
                }
            } else if (category == 3) {
                message = "1. 전체 평점 보기 2. 전문가 평점 보기 3. 신규 평점 등록 4. 뒤로 가기";
                userChoice = ScannerUtil.nextInt(scanner, message);
                if (userChoice == 1) {
                    printAll(movieId, 0);
                } else if (userChoice == 2) {
                    printAll(movieId, 2);
                }
            }

            if (userChoice == 3) {
                writeRating(movieId);
                printAll(movieId, 0);
            }

        }

    }

    private void printList(ArrayList<RatingDTO> list) {
        if (list.isEmpty()) {
            System.out.println("아직 등록된 평점이 존재하지 않습니다.");
        } else {
            System.out.println("--------------------------------");
            System.out.printf("평균 평점: %.2f\n", calculateAverage(list));
            System.out.println("--------------------------------");
            for (RatingDTO r : list) {
                System.out.printf("평점: %d점", r.getRate());

                if (r.getCritic() != null) {
                    System.out.printf(" \"%s\" ", r.getCritic());
                }

                System.out.print("by ");
                userViewer.printNickname(r.getWriterId());
                System.out.println();
            }
        }
    }

    private ArrayList<RatingDTO> filterByCategory(int movieId, int category) {
        ArrayList<RatingDTO> list = ratingController.selectAll(movieId);
        ArrayList<RatingDTO> result = new ArrayList<>();

        for (RatingDTO r : list) {
            if (userViewer.selectCategoryById(r.getWriterId()) == category) {
                result.add(new RatingDTO(r));
            }
        }

        return result;
    }

    private void writeRating(int movieId) {
        RatingDTO r = new RatingDTO();

        r.setMovieId(movieId);
        r.setWriterId(logIn.getId());

        String message;
        message = "평점을 입력해주세요.(1~10)";
        r.setRate(ScannerUtil.nextInt(scanner, message, 1, 10));
        if (userViewer.selectCategoryById(logIn.getId()) == 2) {
            message = "평론을 입력해주세요.";
            r.setCritic(ScannerUtil.nextLine(scanner, message));
        }

        ratingController.add(r);

    }

    private double calculateAverage(ArrayList<RatingDTO> list) {
        int sum = 0;
        for (RatingDTO r : list) {
            sum += r.getRate();
        }

        return (double) sum / list.size();
    }

}
