package day0307;
// 사용자로부터 정수를 입력받는 프로그램,.

// 단, 두자리 양의 정수가 아닌 숫자를 입력하면
// 두자리 양의 정수를 입력할 때까지 다시 입력을 받는다.

import java.util.*;

public class Ex06While02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = 0;

        System.out.println("두자리 양의 정수를 입력해주세요.");
        System.out.print(">");
        number = scanner.nextInt();

        
        while (number < 10 || number >= 100) {

            System.out.println("잘못 입력하셨습니다.");
            System.out.println("두자리 양의 정수 입력");

            System.out.print(">");
            number = scanner.nextInt();
            scanner.nextLine();

        }

        System.out.printf("[%d]\n",number);

    }

}
