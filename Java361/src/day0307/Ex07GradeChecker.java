
package day0307;

//사용자로부터 점수를 입력받아서

//A,B,C,D,F를 출력하는 프로그램.
//단 사용자가 잘못된 점수를 입력하면
//올바른 점수를 입력할 때까지 다시 입력을 받으세요
//7-15

import java.util.*;

public class Ex07GradeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int score = 0;

        System.out.println("점수를 입력하시오");

        score = scanner.nextInt();
        scanner.nextLine();

        // 사용자로부터 입력받은 점수가 유효하지 않은 점수이면
        // 다시입력을받는다.
        while (score < 0 || score > 100) {

            System.out.println("잘못된 점수입니다.");
            System.out.println("점수를 입력하시오");
            System.out.printf(">");
            score = scanner.nextInt();
            scanner.nextLine();
        }

        // 입력받은 점수에 따른 결과를 출력.

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else if (score >= 0) {
            System.out.println("F");
        }
//            else{ System.out.println("잘못된 점수입니다."); }
    }
}
