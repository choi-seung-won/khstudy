package main;

import java.util.Scanner;

import model.UserDTO;
import viewer.*;

public class MovieMain {// viewer클래스 사용. 다른 viewer클래스들간에 참조가 이루어지지 않았으므로 viewer 클래스 하나만 사용할경우 NPE발생

    public static void main(String[] args) {
        
        MovieViewer movieViewer = new MovieViewer();
        RatingViewer ratingViewer = new RatingViewer();
        ShowViewer showViewer = new ShowViewer();
        TheaterViewer theaterViewer = new TheaterViewer();
        UserViewer userViewer = new UserViewer();
        
        Scanner scanner = new Scanner(System.in);

        movieViewer.setRatingViewer(ratingViewer);
        movieViewer.setShowViewer(showViewer);
        movieViewer.setTheaterViewer(theaterViewer);
        movieViewer.setUserViewer(userViewer);
        movieViewer.setScanner(scanner);
        
        
        ratingViewer.setMovieViewer(movieViewer);
        ratingViewer.setShowViewer(showViewer);
        ratingViewer.setTheaterViewer(theaterViewer);
        ratingViewer.setUserViewer(userViewer);
        ratingViewer.setScanner(scanner);
        
        showViewer.setMovieViewer(movieViewer);
        showViewer.setRatingViewer(ratingViewer);
        showViewer.setTheaterViewer(theaterViewer);
        showViewer.setUserViewer(userViewer);
        showViewer.setScanner(scanner);
        
        theaterViewer.setMovieViewer(movieViewer);
        theaterViewer.setRateViewer(ratingViewer);
        theaterViewer.setShowViewer(showViewer);
        theaterViewer.setUserViewer(userViewer);
        theaterViewer.setScanner(scanner);
        
        userViewer.setMovieViewer(movieViewer);
        userViewer.setRatingViewer(ratingViewer);
        userViewer.setShowViewer(showViewer);
        userViewer.setTheaterViewer(theaterViewer);
        userViewer.setScanner(scanner);

        userViewer.showIndex();
        
    }

}
