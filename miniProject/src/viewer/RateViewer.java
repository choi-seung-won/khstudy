package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

import controller.RateController;
import model.RateDTO;
import model.UserDTO;
import util.ScannerUtil;

public class RateViewer {

    private RateController rateController;
    private Scanner scanner;

    private UserDTO logIn;

    private movieViewer movieViewer;
    private theaterViewer theaterViewer;
    private UserViewer userViewer;

    private final int RATE_MIN = 1;
    private final int RATE_MAX = 5;

    public void setLogIn(UserDTO u) {
        if (u != null) {
            logIn = new UserDTO(u);
        } else {
            logIn = null;
        }
    }

    public RateViewer() {

        rateController = new RateController();
        scanner = new Scanner(System.in);

    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setTheaterViewer(theaterViewer theaterViewer) {
        this.theaterViewer = theaterViewer;
    }

    public void setMovieViewer(movieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void printList(int movieId) {

        ArrayList<RateDTO> list = rateController.selectAll(movieId);

        if (list.isEmpty()) {
            System.out.println("\n 아직 등록된 평론이 존재하지 않습니다. \n");
        } else {
            for (RateDTO r : list) {
                printOne(r);
            }
        }
    }

    private void printOne(RateDTO r) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy/m/d/ H:m:s");
        System.out.printf("%s - by ", r.getContent());
        if(r.getWriterId() == 2) {
            System.out.print("전문 평론가");
        }else if(r.getWriterId() == 1) {
            System.out.print("일반 관람객");
        }else {
            System.out.print("관리자");
        }
        //
        //userViewer.printNickname(r.getWriterId());
        //System.out.printf("No : %d NickName : %s",logIn.getId(),logIn.getNickname());
        //System.out.println(logIn.getNickname());
        //error
       
        System.out.printf(" 평점: %d", r.getRate());
        System.out.printf(" at %s\n", sdf.format(r.getWrittenDate().getTime()));
    }

    public void printSelectedList(int movieId) {
        ArrayList<RateDTO> list = rateController.selectExclusive(movieId);
        //ArrayList<RateDTO> list = rateController.selectTest(movieId);
        if (list.isEmpty()) {
            System.out.println("\n 아직 등록된 평론이 존재하지 않습니다. \n");
        } else {
            for (RateDTO r : list) {
                printOne(r);
            }
        }
    }
    
    public void printPublicList(int movieId) {
        ArrayList<RateDTO> list = rateController.selectPublic(movieId);
        if (list.isEmpty()) {
            System.out.println("\n 아직 등록된 평론이 존재하지 않습니다. \n");
        } else {
            for (RateDTO r : list) {
                printOne(r);
            }
        }
    }

    public void writeReply(int writerId, int movieId) {

        RateDTO r = new RateDTO();
        r.setWriterId(writerId);
        r.setMovieId(movieId);

        String message = "평론을 입력해주세요.";
        r.setContent(ScannerUtil.nextLine(scanner, message));
        message = "평점을 입력해주세요.";
        r.setRate(ScannerUtil.nextInt(scanner, message, RATE_MIN, RATE_MAX));

        rateController.add(r);
        
    }

    public void deleteByWriterId(int writerId) {
        rateController.deleteByWriterId(writerId);
    }

}
