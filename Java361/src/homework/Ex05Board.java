package homework;
// 구조체를 사용해서 게시판 프로그램을 작성하세요.
// 게시판에 입력될 게시글은
// 글 번호, 글 제목, 글 작성자, 글 내용 4가지 정보가 입력되어야 하며
// 입력, 목록 출력, 수정, 삭제 기능이 모두 들어가야 합니다.
// 또한 동적할당이 된 배열을 통해서 프로그램이 제어되어야합니다.

import struct.Board;
import util.*;
import java.util.*;

public class Ex05Board {
    public static Scanner scanner;
    public static Board[] array;
    public static int nextId;

    
    
    
    // 1. 메인 메소드 실행
    
    
    // 2. 전역 변수를 초기화하는 메소드 실행
    
    
    // 3. 메뉴 출력을 담당하는 메소드 실행
    
    
    // 3-1. 메뉴에서 입력을 눌렀을 경우 입력 메소드 실행
    
    // 3-2. 메뉴에서 목록출력을 눌렀을 경우 목록 출력 메소드 실행
    
    // 3-2-1. 만약 작성된 글이 존재하지 않으면 메시지 출력.
    
    // 3-2-2-1. 만약 작성된글이 존재하면 글 목록을 간단하게 출력.
    
    // 3-2-2-2. 상세보기할 글의 인덱스나 메뉴로 갈려면 0을 입력받는다.
    
    // 3-2-2-2-1. 선택된 글을 상세 출력하고 수정,삭제, 목록으로중 하나를 입력받는다.
    
    // 3-2-2-2-2. 수정을 선택했을 경우 글 수정 메소드 실행
    
    // 3-2-2-2-3. 삭제를 선택했을 경우 글 삭제 메소드 실행
    
    // 3-2-2-2-4. 목록으로 를 선택했을 경우 목록 출력 메소드 실행
    
    // 3-3. 메뉴에서 종료를 눌렀을 경우 메시지 출력 후 break 실행
    
    public static void main(String[] args) {
        init();
    }
    
    public static void init() {
        
        // Scanner 초기화 
        scanner = new Scanner(System.in);
        
        // array 초기화
        array = new Board[0];
        
        // nextId 초기화
        nextId = 1;
        
        // 메뉴출력메소드호출
        showMenu();
    }
    
    public static void showMenu() {
        while(true) {
            String message = "1. 글작성하기 2. 게시판목록보기 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            // 1~3사이의 int값을 userChoice에 할당
            
            
            if(userChoice == 1) {
                // 글 작성 메소드 호출
                writeBoard();
                
            }else if(userChoice == 2) {
                // 글목록 출력 메소드 호출
                printAll();
            }else if(userChoice == 3) {
                // 메세지출력후종료
                System.out.println("thanksforuse");
                break;
            }
        }
    }
    // D. 글 작성 메소드
    
    public static void writeBoard() {
        // 사용자가 입력한 정보를 담을 Board변수 선언 및 초기화
        Board b = new Board();
        // import한 Struct.Board class 를사용하여 Board b변수 생성
        
        // 글 번호 자동 입력
        b.id = nextId++;
        
        // 각 입력시 출력될 문구를 저장할 String 변수
        String message;
        
        // 글 제목 입력
        message = "게시글의 제목을 입력해주세요.";
        b.title = ScannerUtil.nextLine(scanner, message);
        
        // Board b의 title에 입력값할당
        
        // 글 작성자 입력
        message = "게시글의 작성지를 입력해주세요.";
        b.writer = ScannerUtil.nextLine(scanner, message);
        // 글 내용 입력
        message = "게시글의 내용을 입력해주세요.";
        b.content = ScannerUtil.nextLine(scanner, message);
        // array에 게시글 추가
        array = ArrayUtil.add(array, b);
        
        // ArrayUtil.add = Board[] (array) temp 생성, temp에 Board board[] array에 board 
    }
    
    // E. 글 목록 출력 메소드
    
    public static void printAll() {
        
        if(ArrayUtil.isEmpty(array)) {
            //아직 작성된글이 없으므로 경고메세지 출력
            System.out.println("아직 작성된글이 존재하지 않습니다.");
        }else {
            // 글 목록을 간단하게 출력
            for(int i = 0 ; i < ArrayUtil.size(array); i++){
                System.out.printf("%d. %s \n", ArrayUtil.get(array, i).id,
                        ArrayUtil.get(array, i).title);
            }
            // 사용자로부터 상세보기할 글의 번호나 뒤로가기를 입력받는다.
            String message = "상세보기할 글의 번호나 뒤로가실려면 0 을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            
            // 사용자가 입력한 글 번호가 유효한 글 번호인지 확인하는 메소드를 실행하여
            // 해당 글 번호가 유효하지 않는 동안 다시 입력을 받는다.
            while(!(userChoice == 0 || validateId(userChoice))) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
            
            if(userChoice != 0) {
                //개별 글 상세보기 메소드를 실행한다.
                printOne(userChoice);
            }
        }
        
    }
    
    
    // F. 글 상세보기 메소드
    public static void printOne(int id) {
        
        // 상세보기할 글을 메소드를 사용하여 불러온다.
        Board b = selectById(id);
        
        System.out.println("\n========================");
        System.out.println(b.title);
        System.out.println("--------------------------");
        System.out.println("작성자: "+ b.writer);
        System.out.println("--------------------------");
        System.out.println("내용");
        System.out.println("--------------------------");
        System.out.println(b.content);
        System.out.println("\n========================");
        
        // 사용자로부터 수정, 삭제, 목록으로 중 하나를 입력 받는다.
        String message = " 1. 글 수정 2. 글 삭제 3. 글 목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if(userChoice == 1) {
            //글수정메소드실행
            updateBoard(id);
        }else if(userChoice == 2) {
            //글삭제메소드실행
            deleteBoard(id);
        }else if(userChoice == 3) {
            //목록출력메소드실행
            printAll();
        }
        // 예외처리안함.
    }
    
    // G. 글 수정 메소드
    public static void updateBoard(int id) {
        // 수정할 글의 정보를 불러온다
        Board b = selectById(id);
        
        // 수정시 출력할 내용을 저장할 String 변수
        String message;
        
        // 글 제목 수정
        message = "새로운 제목을 입력해주세요";
        b.title = ScannerUtil.nextLine(scanner, message);
        
        // 글 내용 수정
        message = "새로운 내용을 입력해주세요.";
        b.content = ScannerUtil.nextLine(scanner, message);
        
        // 수정된 글 상세보기 이동
        printOne(id);
        
    }
    // H, 글 삭제 메소드
    public static void deleteBoard(int id) {
        // 삭제 동의를 입력받을 때 출력할 메시지를 저장할 String 변수
        String message;
        
        // 사용자로부터 삭제 여부를 입력받는다.
        message = "해당 글을 정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if(yesNo.equalsIgnoreCase("Y")) {
            // 사용자가 삭제를 원할 경우
            Board b = selectById(id);
            array = ArrayUtil.remove(array, b);
            // 글 삭제후엔 글 전체 목록 출력 메소드 호출
            printAll();
        } else {
            // 사용자가 Y 혹은 y를 입력하지 않았으므로 
            // 상세보기를 실행했던 게시글로 다시 이동한다.
            printOne(id);
        }
    }
    
    // I. 사용자가 입력한 글 번호가 유효한 글 번호이면 true , 그외에는 false 가 리턴되는 메소드
    public static boolean validateId(int id) {
        // id를 담아서 ArrayUtil의 contains()를 실행할 때 사용할 Board변수
        Board b = new Board();
        // b의 id에 파라미터 id를 저장한다.
        b.id = id;
        // ArrayUtil.contains(array,b)의 결과를 리턴한다.
        return ArrayUtil.contains(array, b);
        
    }
    
    
     
    
    // J. 글 번호와 일치하는 Board변수를 array에서 찾아서 return하는 메소드
    
    public static Board selectById(int id) {
        
        //1. validateId를 사용하여 해당 id값을 가진 게시글이 존재하면
        //    해당 게시글의 인덱스를 찾는 코드를 구현한다
        
        //2. 찾은 인덱스를 사용하여 array에서 해당 인덱스를 리턴한다.
        
        if(validateId(id)) {
            
            //Board 변수를 만들어서 id를 저장한다.
            Board b = new Board();
            b.id = id;
            
            // array에서 해당 id값을가진 board변수의 텍스트입력
            int index = ArrayUtil.indexOf(array, b);
            // array의 해당 인덱스를 리턴한다.
            return ArrayUtil.get(array, index);
        }
        //3. 만약 위의 if가 실행되지 않는다면
        //   null을 리턴하여 이 메소드를 실행하는 메소드가 추가적인 코드 처리를 할 수 있도록한다.
        
        return null;
        
    }
}
    
    

