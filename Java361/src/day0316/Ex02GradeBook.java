package day0316;
// 학생 한명의 정보를 메뉴를 통해서 관리하는 프로그램을 작성하시오.

// 단, day0316.Student 클래스 객체를 사용해서 관리하시오

// 9-15

import java.util.*;
import util.*;

import day0316.Student;

public class Ex02GradeBook {

    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    public static Scanner scanner;

    public static Student s;
    public static int id;
    public static String name;
    public static int korean;
    public static int english;
    public static int math;

    public static void main(String[] args) {

        init();

    }

    public static void init() {
        scanner = new Scanner(System.in);
        s = new Student();
        showMenu();
    }

    public static void showMenu() {

        while (true) {
            String message = "1.입력 2.출력 3.종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                print();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;

            }
        }
    }

    public static void insert() {

        String message = "번호를 입력하시오";
        s.id = ScannerUtil.nextInt(scanner, message);
        message = "이름을 입력하시오";
        s.name = ScannerUtil.nextLine(scanner, message);
        message = "국어점수를 입력하시오";
        s.korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        message = "영어점수를 입력하시오";
        s.english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        message = "수학점수를 입력하시오";
        s.math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        //Student s = new Student(id, name, korean, english, math);
        //s.printInfo();

    }
    public static void print() {
        if(s.korean == -1) {
            System.out.println("korean 아직 입력되지 않은 상태입니다.");
        }else {
            s.printInfo();
        }
    }

}
