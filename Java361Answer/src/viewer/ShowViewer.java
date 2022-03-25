package viewer;

import java.util.Scanner;

import model.UserDTO;

import java.util.ArrayList;

public class ShowViewer {

    private MovieViewer movieViewer;
    private RatingViewer ratingViewer;
    private TheaterViewer theaterViewer;
    private UserViewer userViewer;
    private Scanner scanner;
    private UserDTO logIn;
    
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

}
