package day0304;
// 사용자로부터 점수를 입력받아서
// 90점이상: A
// 80점대: B
// 70점대: C
// 60점대: D
// 그외: F
// 가 출력되는 프로그램을 작성해보세요 

import java.util.*;
public class Ex07GradeChecker {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("점수를 입력하시오");
        
        int score = scanner.nextInt();
        
        if(score >= 90) {
            System.out.printf("A");
            
        }else if(score > 80) {
            System.out.printf("B");
        }else if(score >= 70) {
            System.out.printf("C");
        }else if(score >= 60) {
            System.out.printf("D");
        }else {
            System.out.printf("F");
        }
        System.out.println("학점입니다.");
        
        
        scanner.close();
    }

}
