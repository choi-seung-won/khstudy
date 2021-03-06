package day0304;

//사용자로부터 국어 영어 수학 점수를 입력 받아서
// 검정고시 결과를 출력해주는 프로그램을 작성하시오
// 검정고시의 경우 만약 평균이 70미만이거나 혹은
// 한 과목이라도 60점 미만일 경우 탈락이 됩니다.

// 예시: 50 50 50 > 탈락
//      80 80 80 > 합격
//      100 100 20 > 탈락

import java.util.*;

public class Ex09ResultChecker {

    public static void main(String[] args) {

        // 프로그램에서 사용할 상수들
        // 1. 통과 기준의 총점
        final int SUM_MINIMUM = 210;
        // 2. 통과 기준의 개별 점수
        final int SCORE_MINIMUM = 60;

        Scanner scanner = new Scanner(System.in);

        System.out.println("국어 점수를 입력하시오.");

        int score_korean = scanner.nextInt();

        System.out.println("영어 점수를 입력하시오.");

        int score_english = scanner.nextInt();

        System.out.println("수학 점수를 입력하시오.");

        int score_math = scanner.nextInt();

        // 탈락 조건.
        // 총점이 210미만일경우 (=평균이 70미만일경우)
        // 국어/영어/수학점수중 하나의 점수가 60점 미만일경우

        int sum = score_korean + score_english + score_math;

        /*
         * if (sum < 210) { System.out.println("탈락"); } else if (score_korean < 60) {
         * System.out.println("탈락"); } else if (score_english < 60) {
         * System.out.println("탈락"); } else if (score_math < 60) {
         * System.out.println("탈락"); } else { System.out.println("합격"); }
         */

        if (sum < SUM_MINIMUM || score_korean < SCORE_MINIMUM || score_english < SCORE_MINIMUM
                || score_math < SCORE_MINIMUM) {
            System.out.println("탈락입니다.");
        } else {
            System.out.println("합격입니다.");
        }

        scanner.close();

    }

}
