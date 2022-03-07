package day0307;
// 사용자로부터 이름,나이,키, 몸무게를 차례대로 입력받아서
// BMI를 계산하고 비만도 결과값을 출력하는 프로그램을 작성하세요.

// BMI 공식은 몸무게(kg) / 키(m) / 키(m) 입니다.

//기네스북에 따르자면, 세계에서 가장 키가 컸던 사람은 2.72m였습니다
//기네스북에 따르자면, 세계에서 가장 무거웠던 사람은 635kg였습니다.

//BMI에 따른 비만도
//18.5미만: 저체중
//18.5이상 23미만:정상체중
//23이상 25미만:과체중
//25이상: 미만

import java.util.Scanner;

public class Ex04BmiChecker {

    public static void main(String[] args) {
        
        // 상수
        // 1. 입력가능한 키의 최소 값
        final double HEIGHT_MINIMUM = 0;
        
        // 2. 입력가능한 키의 최대 값
        
        final double HEIGHT_MAXIMUM=2.72;

        
        // 3. 입력 가능한 몸무게의 최소 값

        final double WEIGHT_MINIMUM = 0;
        
        // 4. 입력 가능한 몸무게의 최대 값
        
        final double WEIGHT_MAXIMUM=635;

        
        // 5. BMI 기준점1
        
        final double BMI_STANDARD1 = 18.5;
                
        // 6. BMI 기준점2
        
        final double BMI_STANDARD2 = 23;
        
        // 7. BMI 기준점3
        
        final double BMI_STANDARD3 = 25;
        
        Scanner scanner = new Scanner(System.in);
        
        // 1. 이름을 입력 받는다.
        
        System.out.println("이름을 입력하세요");
        System.out.print(">");
        
        String name = scanner.nextLine();
        
        // 2. 나이를 입력 받는다.
        
        System.out.println("나이를 입력하세요");
        System.out.print(">");
        
        int age = scanner.nextInt();
        scanner.nextLine();
        
        // 3. 키를 입력받는다.
        
        System.out.println("키를 입력하세요");
        System.out.print(">");
        
        double height = scanner.nextDouble()*0.01;
        scanner.nextLine();
        
        // 4. 키가 올바른지 체크한다.
        
        if(height > HEIGHT_MAXIMUM || height <= HEIGHT_MINIMUM ) {
            System.out.println("잘못된 키를 입력하여 프로그램을 종료합니다.");
        } else {
            // 4-1. 올바른 키의 범위에 속하므로 몸무게를 입력받는다.
            System.out.println("몸무게를 입력하세요");
            System.out.print(">");
            
            double weight = scanner.nextDouble();
            scanner.nextLine();
            
            // 5. 몸무게가 올바른지 체크한다.
            
            if(weight > WEIGHT_MAXIMUM || weight <= WEIGHT_MINIMUM ) {
                // 올바른 몸무게의 범위에 속하지 않으므로 경고 메세지만 출력
                
                System.out.println("잘못된 몸무게를 입력하여 프로그램을 종료합니다.");
            }else {
                
                // 5-1. 올바른 몸무게의 범위에 속하므로
                //      BMI 계산 후 결과 출력
                
                double BMI = weight / height / height ;
                System.out.printf("BMI: %.2f 비만도:",BMI);
                
                if(BMI > BMI_STANDARD3) {
                    System.out.print("비만");
                }else if(BMI >= BMI_STANDARD2 && BMI < BMI_STANDARD3) {
                    System.out.print("과체중");
                }else if(BMI >= BMI_STANDARD1 && BMI < BMI_STANDARD2) {
                    System.out.print("정상체중");
                }else {
                    System.out.print("저체중");
                }
            }
            System.out.println("입니다.");
        }
        
        
     scanner.close();
     

    }

}
