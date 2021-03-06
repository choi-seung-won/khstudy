package day0307;

//사용자로부터 이름,나이,키, 몸무게를 차례대로 입력받아서
//BMI를 계산하고 비만도 결과값을 출력하는 프로그램을 작성하세요.

//BMI 공식은 몸무게(kg) / 키(m) / 키(m) 입니다.

//기네스북에 따르자면, 세계에서 가장 키가 컸던 사람은 2.72m였습니다
//기네스북에 따르자면, 세계에서 가장 무거웠던 사람은 635kg였습니다.

//BMI에 따른 비만도
//18.5미만: 저체중
//18.5이상 23미만:정상체중
//23이상 25미만:과체중
//25이상: 미만

//만약 사용자가 잘못된 키 혹은 몸무게를 입력하면
//올바른값이 들어올때까지 다시 입력을 받으세요.
//7-40

import java.util.*;

public class Ex08BmiChecker2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double WEIGHT, HEIGHT, MAX_WEIGHT, MIN_WEIGHT, MAX_HEIGHT, MIN_HEIGHT = 0;
        double BMI_STANDARD1 = 18.5, BMI_STANDARD2 = 23, BMI_STANDARD3 = 25;

        MIN_WEIGHT = 0;
        MIN_HEIGHT = 0;
        MAX_WEIGHT = 635;
        MAX_HEIGHT = 272;
        

        System.out.println("이름을 입력하시오");
        System.out.print(">");

        String name = scanner.nextLine();

        System.out.println("나이를 입력하시오");
        System.out.print(">");

        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("키를 입력하시오");
        System.out.print(">");

        HEIGHT = scanner.nextDouble();

            while (HEIGHT >= MAX_HEIGHT || HEIGHT <= MIN_HEIGHT) {
                System.out.println("잘못된 값입니다. 다시 입력하시오");
                System.out.print(">");

                HEIGHT = scanner.nextDouble();
                scanner.nextLine();
            }
            
            System.out.println("체중을 입력하시오");
            System.out.print(">");

            WEIGHT = scanner.nextDouble();
            scanner.nextLine();

            //몸무게를 검증하여
            //올바르지 않으면 다시 입력받는다.
            
            
            while ( !(WEIGHT > MIN_WEIGHT && WEIGHT <= MAX_WEIGHT)) {
                System.out.println("잘못된 값입니다. 다시 입력하시오");
                System.out.print(">");
                WEIGHT = scanner.nextDouble();
            } 
            
                
                double BMI = WEIGHT / HEIGHT / HEIGHT;

                System.out.printf("BMI : %.2f이며 비만도는 ", BMI);
                if (BMI < BMI_STANDARD1) {
                    System.out.println("저체중입니다.");
                } else if (BMI < BMI_STANDARD2) {
                    System.out.println("정상체중입니다.");
                } else if (BMI < BMI_STANDARD3) {
                    System.out.println("과체중입니다.");
                } else {
                    System.out.println("비만입니다.");
                }
            }


    }

