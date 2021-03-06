package day0307;
// 사용자로부터 성별, 나이, 신체등급 순으로 입력받아서

// 현역, 공익, 면제 중 하나를 출력하는 프로그램
// 단, 성별의경우 int 값으로 입력을 받아서
// 1이면 남자 2면 여자로 판단합니다.
// 만약 여자일경우, 추가적인 입력 없이
// "여성에게는 국방의 의무가 부여되지 않습니다" 만 출력이 됩니다.
// 또한, 남자지만 19세 미만의 미성년자일 경우
// "미성년자에게는 아직 신체등급이 존재하지 않습니다" 가 출력이 됩니다.
// 남자 성인일 경우
// 1~3: 현역
// 4: 공익
// 그외: 면제가 됩니다

//4-20

import java.util.*;

public class Ex02ArmyChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("성별을 숫자로 입력하시오 남자:1 여자:2");
        System.out.print(">");
        int gender_as_num = scanner.nextInt();
        scanner.nextLine();

        if (gender_as_num == 2) {
            System.out.println("여성에게는 국방의 의무가 부여되지 않습니다");

        } else {

            System.out.println("나이를 입력");
            System.out.print(">");
            int age = scanner.nextInt();
            scanner.nextLine();

            // 나이에 따른 코드를 결정

            if (age < 19) {
                // 미성년자이므로 메세지만 출력
                System.out.println("미성년자에게는 아직 신체등급이 존재하지 않습니다");

            } else {

                // 남자 성인이므로, 신체등급을 입력받는다.

                System.out.println("신체등급을 입력");
                System.out.print(">");
                int grade = scanner.nextInt();
                scanner.nextLine();

                if (grade <= 3) {

                    System.out.println("현역");

                } else if (grade == 4) {

                    System.out.println("공익");
                } else {
                    System.out.println("면제");
                }

                scanner.close();
            }
        }
    }
}