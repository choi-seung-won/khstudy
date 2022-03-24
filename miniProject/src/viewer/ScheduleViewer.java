package viewer;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import controller.scheduleController;
import model.UserDTO;
import model.movieDTO;
import model.scheduleDTO;
import util.ScannerUtil;

public class ScheduleViewer {

    private scheduleController scheduleController;
    private Scanner scanner;

    private movieViewer movieViewer;
    private UserViewer userViewer;

    private UserDTO logIn;

    public void setLogIn(UserDTO u) {
        if (u != null) {
            logIn = new UserDTO(u);
        } else {
            logIn = null;
        }
    }

    public ScheduleViewer() {

        scheduleController = new scheduleController();
        scanner = new Scanner(System.in);
        movieViewer m = new movieViewer();
        

    }
    

    public void setUserViewer(UserViewer userViewer) {

        this.setUserViewer(userViewer);

    }

    public void setMovieViewer(movieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }
    
    public void getMovieInformation(int id) {

        
        
    }

    public void printList(int theaterId) {

        ArrayList<scheduleDTO> list = scheduleController.selectAll(theaterId);
        if (list.isEmpty()) {
            System.out.println("\n 아직 등록된 상영정보가 존재하지않습니다. \n");
        } else {
            for (scheduleDTO s : list) {
                printOne(s);
            }
        }

    }

    public void printOne(scheduleDTO s) {

        SimpleDateFormat sdf = new SimpleDateFormat("yy/m/d H:m:s");
        System.out.printf("%s \n", s.getShowTime().getTime());
        System.out.printf("%d \n", s.getMovieid());

        // System.out.println("%s \n");

    }

    public void deleteByMovieId(int movieId) {

        String message = "정말로 삭제하시겠습니까?";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {

            scheduleController.deleteByMovieId(movieId);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제 취소.");
        }
    }
    
    private void update(int id) {
        scheduleDTO s = scheduleController.selectOne(id);
        String message;
        
        message = "임의의 상영정보";
    }

}
