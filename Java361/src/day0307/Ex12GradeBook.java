package day0307;
// 사용자로부터

// 번호,이름,국어,영어,수학 순으로 입력받아서
// 다음과 같이 출력되는 프로그램을 작성하시오

// 번호: 0##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0#3점
// 총점: 0##점 평균: 0##.##점

//단 입력과 출력을 분리해서
// 사용자가 입력을 누를때에만 입력이 되고
// 출력을 누르면 출력이 되게 코드를 작성하시고
// 사용자가 종료를 선택하기 전까지는
// 해당 기능이 무한히 반복되게 코드를 작성해보세요

//힌트 ) 변수의선언위치

// 심화가정: 만약 사용자가 입력한적 없이
// 출력을 선택하면
// "아직 입력된 정보가 없습니다" 만 출력되게
// 코드를 작성하시오

import java.util.*;

public class Ex12GradeBook {

    public static void main(String[] args) {
        
        
        int num = 0;
        String name = "none";
        double korean = 0,math = 0,english = 0;
        

        Scanner scanner = new Scanner(System.in);

        while (true) {
            


            
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                
                System.out.println("번호");
                System.out.print(">");
                
                num = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("이름");
                System.out.print(">");

                name = scanner.nextLine();

                System.out.println("국어점수 입력");
                System.out.print(">");
                korean = scanner.nextDouble();
                scanner.nextLine();
                
                
                if(korean > 100 || korean <0 ){
                    System.out.println("잘못된 입력값입니다.");
                    break;
                }
                
                System.out.println("영어점수 입력");
                System.out.print(">");
                english = scanner.nextDouble();
                
                if(english > 100 || korean <0 ){
                    System.out.println("잘못된 입력값입니다.");
                    break;
                }
                
                System.out.println("수학점수 입력");
                System.out.print(">");
                math = scanner.nextDouble();
                if(math > 100 || math <0 ){
                    System.out.println("잘못된 입력값입니다.");
                    break;
                }else {
                    
                    System.out.println("입력종료.");
                }
                
                    
                
               

            } else if (userChoice == 2) {
                
                if(num == 0) {
                    System.out.println("아직 입력된 정보가 없습니다.");
                    return;
                }
              
                double sum = korean + math + english;
                double avg = sum / 3;

                System.out.printf("번호: %d 이름: %s 국어: %.2f 영어: %.2f 수학: %.2f \n 총점 : %.2f 평균 : %.2f \n",num,name,korean,
                        english,math,sum,avg);
                
                
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                return;
            }
        }

    }

}
