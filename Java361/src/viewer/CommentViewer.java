package viewer;

import java.util.Scanner;

import controller.BoardController;

public class CommentViewer {

    private Scanner scanner;
    private BoardViewer boardViewer;
    private UserViewer userViewer;

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    public BoardViewer() {
        BoardController = new BoardController();
        scanner = new Scanner(System.in);
    }

    public CommentViewer() {
        scanner = new Scanner(System.in);

        boardViewer = new BoardViewer();
        boardViewer.setUserViewer(this);

    }

}
