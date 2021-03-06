package day0314;
// 한번에 여러 학생을 관리하는 프로그램.

// 단, 최대 관리 가능한 학생은 5명이다.
// 단, 한번에 한명씩만 입력이 가능한데
// 만약 다섯번째 학생을 입력한 후에
// 또 입력을 선택할 시에는 더이상 입력할 수 없다 라는 메세지만 출력이 되어야 한다.
// 또한 출력 시에는 현재 입력된 학생까지만 출력이 된다.
// 또한 입력 시에 

import java.util.*;
import util.ScannerUtil;

public class Ex04GradeBook2 {

    // 전역 상수
    // 1. 관리할 학생의 최대 숫자
    public static final int STUDENT_SIZE = 5;
    // 2. 과목의 숫자
    public static final int SUBJECT_SIZE = 3;
    // 3. 가능한 최소 점수
    public static final int SCORE_MIN = 0;
    // 4. 가능한 최대 점수
    public static final int SCORE_MAX = 100;

    // 전역 변수
    // 1. 입력을 처리할 Scanner 클래스 변수
    public static Scanner scanner;
    // 2. 학생 번호를 저장할 배열
    public static int[] idArray;
    // 3. 학생 이름을 저장할 배열
    public static String[] nameArray;
    // 4. 학생의 국어점수를 저장할 배열
    public static int[] koreanArray;
    // 5. 학생의 영어점수를 저장할 배열
    public static int[] englishArray;
    // 6. 학생의 수학점수를 저장할 배열
    public static int[] mathArray;
    // 7. 각 배열의 현재 입력할 공통 인덱스
    public static int currentIndex;

    // 7-40
    public static boolean inputSwitch = false;

    public static void main(String[] args) {

        // 변수의 초기화
        scanner = new Scanner(System.in);
        idArray = new int[STUDENT_SIZE];
        nameArray = new String[STUDENT_SIZE];
        koreanArray = new int[STUDENT_SIZE];
        englishArray = new int[STUDENT_SIZE];
        mathArray = new int[STUDENT_SIZE];

        currentIndex = 0;

        while (true) {

            String message = "1. 입력 2. 출력 3. 종료";
            int userInput = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userInput == 1) {
                insertInfo();
            } else if (userInput == 2) {
                printInfo();
            } else if (userInput == 3) {
                System.out.println("사용해주셔서감사합니다.");
                break;
            } else {
                System.out.println("잘못된 값입니다.");
            }
        }
    }

    public static void insertInfo() {

        if (currentIndex < STUDENT_SIZE) {
            // 아직5명을입력하지않았을경우
            System.out.println("==========================");
            System.out.printf("%d번 학생 입력하기\n",currentIndex+1);
            System.out.println("==========================");

            
            String message = "학생의 번호를 입력해주세요";
            idArray[currentIndex] = ScannerUtil.nextInt(scanner, message);
            
            
            message = "학생의 이름을 입력해주세요";
            nameArray[currentIndex] = ScannerUtil.nextLine(scanner, message);
            
            
            message = "학생의 국어 점수를 입력해주세요";
            koreanArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            
            
            message = "학생의 영어 점수를 입력해주세요";
            englishArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            
            
            message = "학생의 수학 점수를 입력해주세요";
            mathArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            currentIndex++;
            //inputSwitch = true;
        } else {
            // 5명초과일경우
            System.out.println("이미 5명 모두 정보가 입력되어있습니다.");
        }
    }

    public static void printInfo() {

        if (currentIndex > 0) {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println("===================================");
                System.out.printf("%d번째 학생의 정보\n" , i+1);
                System.out.println("===================================");
                System.out.printf("번호 : %03d번 ,이름 : %s\n", idArray[i], nameArray[i]);
                System.out.printf("국어 : %03d점 , 영어 : %03d점 수학 : %03d점", koreanArray[i], englishArray[i], mathArray[i]);
                // loop돌려얗ㅁ

                int sum = koreanArray[i] + englishArray[i] + mathArray[i];

                double average = (double) sum / SUBJECT_SIZE;

                System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

            }

        } else {
            System.out.println("아직 입력된 정보가 존재하지 않습니다.");
        }

    }

}