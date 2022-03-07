package day0307;

// 사용자로부터 점수를 입력받아서
// A,B,C,D,F를 출력하는 프로그램
// 단, 사용자가 -1을 입력하면
// 사용해주셔서 감사합니다. 라고 출력이 되고
// 만약 그 외에 잘못된 정수를 입력하면
// 다시 입력하게 만드시오

// 8-35

import java.util.*;

public class Ex11GradeChecker02 {
    
    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("점수를 입력하시거나 종료하실려면 -1을 입력해주세요.");
            System.out.print("> ");
         
            int score = scanner.nextInt();
            
            while( !(score >= -1 && score <= 100)) {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("점수를 입력하시거나 종료하실려면 -1을 입력해주세요.");
                System.out.print(">");
                score = scanner.nextInt();
                
            }
            
            if(score == -1) {
                System.out.println("사용해주셔서 감사합니다.");

                break;
                //사용자가 추가입력없이 종료를 원할때
                
            }else {
                // 사용자가 입력한 점수를 토대로
                // 결과를 출력해야할 때
                    
                if (score>=90){
                    System.out.println("A");
                }else if (score>=80) {
                    System.out.println("B");
                }else if (score>=70) {
                    System.out.println("C");
                }else if (score>=60) {
                    System.out.println("D");
                }else {
                    System.out.println("F");
                }
                
            }
            
            
            
        }
        /*
        
        System.out.println("점수를 입력하시오");
        System.out.print(">");
        int score = scanner.nextInt();
        scanner.nextLine();
        
        while(score < 0 || score > 100) {
            System.out.println("잘못된 입력입니다 ");
            System.out.print("다시 입력하시오\n");
            
            score = scanner.nextInt();
            scanner.nextLine();
            
            if(score == -1) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
                
            }else if (score>=90){
                System.out.println("A");
            }else if (score>=80) {
                System.out.println("B");
            }else if (score>=70) {
                System.out.println("C");
            }else if (score>=60) {
                System.out.println("D");
            }else {
                System.out.println("F");
            }
        }
        */
        
    }

}
