package day0304;

import java.util.Scanner;

//사용자로부터 번호, 이름 영어점수, 수학점수, 국어점수를

// 차례대로 입력받아서
// 다음과 같은 양식으로 출력되는 프로그램을 작성하시오

// 결과)
// 번호: 0##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점

public class Ex02GradeBook {

    public static void main(String[] args) {
        
        //과목의 갯수를 저장한 상수
        final int SUBJECT_SIZE = 3;

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);

        System.out.println("번호 입력\n");

        // scanner.nextLine();
        int number = scanner.nextInt();

        scanner.nextLine();

        System.out.println("이름 입력 >\n");

        String name = scanner2.nextLine();

        System.out.println("영어점수 입력 > \n");

        int score_eng = scanner3.nextInt();

        scanner3.nextLine();

        System.out.println("수학점수 입력 > \n");

        int score_math = scanner4.nextInt();

        scanner4.nextLine();

        System.out.println("국어점수 입력 > \n");

        int score_Nlang = scanner5.nextInt();
        scanner5.nextLine();

        System.out.printf("번호 : %03d번 이름 : %s", number, name);

        System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점", score_Nlang, score_eng, score_math);

        int sum = score_Nlang + score_math + score_eng;

        // 3-2. 평균을 담당할 변수를 선언하고 평균을 계산하여 저장한다.

        double average = sum / SUBJECT_SIZE;

        System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);

        scanner.close();

        scanner2.close();

        scanner3.close();

        scanner4.close();

        scanner5.close();

    }

}
