package day0317;
// arraylist를 사용하여 학생 관리 프로그램을 작성하시오.
// 단, 개별학생에 대한 수정, 삭제 기능도 포함됭어야 합니다.
import java.util.ArrayList;
import java.util.Collections;

import day0316.Student2;

import struct.Board;
import util.ScannerUtil;

import java.util.Scanner;

public class Ex03GradeBook01 {
    
    // 전역 상수
    
    private static final int SCORE_MIN = 0;
    private static final int SCORE_MAX = 100;
    
    
    // 전역변수
    private static Scanner scanner;
    private static int nextId;
    
    private static ArrayList<Student2> list;
    
    public static void main(String[] args) {
        init();
    }
    
    private static void init() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        nextId=1;
        
        showMenu();
    }
    
    public static void showMenu() {

        while (true) {
            String message = "1. 학생 정보 입력 2. 학생 목록 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                insertStudent();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;

            }
        }
    }
    
    // 4. 정보 입력 메소드
    
    public static void insertStudent() {

        Student2 s = new Student2();
        
        s.setId(nextId++);
        String message = "이름을 입력하시오";
        s.setName(ScannerUtil.nextLine(scanner, message)); 
        message = "국어점수를 입력하시오";
        s.setKorean(ScannerUtil.nextInt(scanner, message,SCORE_MIN,SCORE_MAX));
        message = "영어점수를 입력하시오";
        s.setEnglish(ScannerUtil.nextInt(scanner, message,SCORE_MIN,SCORE_MAX));
        message = "수학점수를 입력하시오";
        s.setMath(ScannerUtil.nextInt(scanner, message,SCORE_MIN,SCORE_MAX));
        
        list.add(s);

    }
    
    public static void printAll() {
        if(list.isEmpty()) {
            System.out.println("아직 입력된 학생의 정보가 존재하지않습니다.");
        }else {
           for(Student2 s : list) {
               System.out.printf("%d번. %s\n" , s.getId(), s.getName());
           }
           
           String message="상세보기할 학생의 번호나 뒤로 가실려면 0 을 입력해주세요. ";
           int userChoice = ScannerUtil.nextInt(scanner, message);
          
           Student2 temp = new Student2();
           temp.setId(userChoice);
           
           while(userChoice != 0 && list.contains(temp)) {
               System.out.println("잘못 입력하셨습니다.");
               
               userChoice = ScannerUtil.nextInt(scanner, message);
               temp.setId(userChoice);
           }
           if(userChoice != 0) {
               printOne(userChoice);
           }
        
        }
    }
    
    private static void printOne(int id) {
        
        Student2 s = selectOneById(id);
        
        s.printInfo();
        String message = "1.수정 2.삭제 3.목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        
        if(userChoice == 1) {
            update(id);
        }else if(userChoice == 2) {
            delete(id);
        }else if(userChoice == 3) {
            printAll();
        }
        
    }
    
    private static void update(int id) {
        Student2 s = selectOneById(id);
        
        String message;
        
        message = "학생의 새로운 국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        message = "학생의 새로운 영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        message = "학생의 새로운 수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        printOne(id);
    }
    
    private static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N ";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if(yesNo.equalsIgnoreCase("Y")) {
            Student2 s = selectOneById(id);
            list.remove(s);
            printAll();
            
        }else {
            printOne(id);
        }
    }

    private static Student2 selectOneById(int id) {
        Student2 s =null;
        
        s.setId(id);
        
        if(list.contains(s)) {
            return list.get(list.indexOf(s));
        }
        
        return null;
    }
}
