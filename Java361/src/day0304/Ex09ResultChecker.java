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

        Scanner scanner = new Scanner(System.in);

        System.out.println("국어 점수를 입력하시오.");

        double score_korean = scanner.nextDouble();

        System.out.println("영어 점수를 입력하시오.");

        double score_english = scanner.nextDouble();

        System.out.println("수학 점수를 입력하시오.");

        double score_math = scanner.nextDouble();

        if (score_korean < 60) {
            System.out.println("탈락");
        } else if (score_english < 60) {
            System.out.println("탈락");
        } else if (score_math < 60) {
            System.out.println("탈락");

        } else {
            System.out.println("합격");
        }

    }

}
