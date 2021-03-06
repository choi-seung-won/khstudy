package day0314;

import java.util.*;

import util.ScannerUtil;

public class Ex02GradeBook {
    public static void printInfo(int id, String name, int korean, int english, int math) {

        //상수
        //과목의갯수
        final int SUBJECT_SIZE = 3;
        
        //번호이름출력
        System.out.printf("번호 : %03d번 ,이름 : %s\n", id, name);
        //국영수점수출력
        System.out.printf("국어 : %03d점 , 영어 : %03d점 수학 : %03d점", korean , english , math);
      
        
        //총점평균출력
        int sum = korean + english + math;
        double average = (double)sum / SUBJECT_SIZE ; 
        System.out.printf("총점: %03d점 평균: %06.2f점\n",sum , average);
    }

    public static void main(String[] args) {

        // 1. 가능한 최소 점수
        final int SCORE_MIN = 0;
        // 2. 가능한 최대 점수
        final int SCORE_MAX = 100;

        // 변수
        // 1.입력을 처리할 Scanner 클래스 변수

        Scanner scanner = new Scanner(System.in);

        // 2. 번호, 이름 ,국어 ,영어 , 수학 점수를 각각 저장할 변수
        int id = 0;
        String name = "";
        int korean = 0;
        int english = 0;
        int math = 0;

        // 3. 입력여부를 저장할 boolean변수
        boolean inputSwitch = false;

        while (true) {
            String message = "1. 입력 2. 출력 3. 종료";

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                
                //입력시 각 메시지를 저장할 String 변수 선언
                String inputMessage;
                
                // 번호 입력
                inputMessage = "학생의 번호를 입력해주세요";
                id = ScannerUtil.nextInt(scanner, inputMessage);
                // 이름 입력
                inputMessage = "학생의 이름을 입력해주세요.";
                name = ScannerUtil.nextLine(scanner, inputMessage);
                
                //국어점수입력
                inputMessage = "학생의 국어 점수를 입력해주세요.";
                korean = ScannerUtil.nextInt(scanner, inputMessage , SCORE_MIN , SCORE_MAX);
                
                //영어점수입력

                inputMessage = "학생의 영어 점수를 입력해주세요.";
                english = ScannerUtil.nextInt(scanner, inputMessage , SCORE_MIN , SCORE_MAX);
                

                //수학점수입력
                inputMessage = "학생의 수학 점수를 입력해주세요.";
                math = ScannerUtil.nextInt(scanner, inputMessage , SCORE_MIN , SCORE_MAX);
                
                // 저장여부를 저장한 inputSwitch값을 true로 변경
                inputSwitch = true;

            } else if (userChoice == 2) {

                if (inputSwitch) {

                    // 입력이 한번이라도 되었으므로 출력 메소드 실행

                    printInfo(id, name, korean, english, math);

                } else {
                    // 입력이 안되었으므로 메시지만 출력
                    System.out.println("아직 입력된 정보가 존재하지 않습니다.");
                }

            } else if (userChoice == 3) {

                // 메세지 출력 후 종료
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

    }


}
