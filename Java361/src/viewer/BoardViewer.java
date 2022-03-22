package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BoardController;
import model.BoardDTO;
import model.UserDTO;
import util.ScannerUtil;

public class BoardViewer {
    private final String DATE_FORMAT = "yy-MM-dd H:m:s";

    private BoardController boardController;
    private Scanner scanner;
    private UserDTO logIn;
    private UserViewer userViewer;
    private ReplyViewer replyViewer;

    public void setLogIn(UserDTO u) {
        if (u != null) {
            logIn = new UserDTO(u);
        } else {
            logIn = null;
        }

    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
        replyViewer.setUserViewer(userViewer); // userviewer와 replyviewer의연동
    }

    public void setReplyViewer(ReplyViewer replyViewer) {
        this.replyViewer = replyViewer;
    }

    public BoardViewer() {
        boardController = new BoardController();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        String message = "1. 새 글 등록 2. 글 목록보기 3. 메인화면으로 ";
        while (true) {

            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {

                writeBoard();

            } else if (userChoice == 2) {

                printAll();

            } else if (userChoice == 3) {
                System.out.println("thanks for use");
                break;
            }
        }
    }

    private void writeBoard() {
        BoardDTO b = new BoardDTO();

        String message;
        message = "글의 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        b.setWriterId(logIn.getId());

        message = "글의 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        boardController.add(b);

    }

    private void printAll() {
        ArrayList<BoardDTO> list = boardController.selectAll();
        if (list.isEmpty()) {

            System.out.println("아직 등록된 글이 존재하지 않습니다.");

        } else {
            for (BoardDTO b : list) {
                System.out.printf("%d. %s\n", b.getId(), b.getTitle());

            }
            String message = "상세보기할 글의 번호 또는 뒤로갈려면 0";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            while (userChoice != 0 && boardController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    private void printOne(int id) {
        BoardDTO b = boardController.selectOne(id);

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        System.out.println("제목: " + b.getTitle());
        System.out.println("작성자: ");
        userViewer.printNickname(b.getWriterId());
        System.out.println();
        System.out.println("작성일: " + sdf.format(b.getWrittenDate().getTime()));
        System.out.println("수정일: " + sdf.format(b.getUpdatedDate().getTime()));

        System.out.println(b.getContent());

        replyViewer.printList(id);

        String message;

        int optionMin, optionMax;

        if (b.getWriterId() == logIn.getId()) {
            
            message = "1. 수정 2. 삭제 3. 목록으로 가기";
            optionMin = 1;
            optionMax = 3;
            
            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
            if (userChoice == 1) {
                update(id);

            } else if (userChoice == 2) {
                delete(id);

            } else { ////////여기서에러. 코멘트달기 > 글목록으로감. 목록으로가기 > 동작 X
                printAll();
            }
            
        } else {
            message = "1. 댓글 달기 2. 목록으로 가기";
            optionMin = 1;
            optionMax = 2;
            
            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
            if (userChoice == 1) {
                replyViewer.writeReply(logIn.getId(), id);
                printOne(id);
            } else if (userChoice == 2) {
                printAll();
            }
        }



    }

    private void update(int id) {
        BoardDTO b = boardController.selectOne(id);
        String message;

        message = "새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));
        message = "새로운 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        boardController.update(b);
        printOne(id);
    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            boardController.delete(id);
            printAll();
        } else {
            printOne(id);

        }
    }

    public void deleteByWriterId(int writerId) {
        boardController.deleteByWrierId(writerId);
    }

}
