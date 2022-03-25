package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.*;
import model.*;
import util.ScannerUtil;

public class TheaterViewer {

    private UserViewer userViewer;
    private MovieViewer movieViewer;
    private RatingViewer rateViewer;
    private ShowViewer showViewer;
    private Scanner scanner;
    private UserDTO logIn;
    
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }
    public void setRateViewer(RatingViewer rateViewer) {
        this.rateViewer = rateViewer;
    }
    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }
    

    public void setScanner(Scanner scanner) {
        
        this.scanner = scanner;
        
    }
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }
}
