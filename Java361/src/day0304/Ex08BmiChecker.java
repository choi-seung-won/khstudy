package day0304;
// 사용자로부터 이름,나이,키, 몸무게를 차례대로 입력받아서
// 다음과 같은 형식으로 출력되게 프로그램을 작성하시오

//결과))
// 이름: ### 나이: 0##세
// 키: #.##M 몸무게: 0##.##kg
// BMI: ##.## 비만도: ###

// BMI 계산 공식은 몸무게(kg 단위) / 키(m 단위) / 키(m 단위) 입니다.

// BMI에 따른 비만도는
// ~18.5 미만: 저체중
// 18.5 이상 23 미만: 정상체중
// 23이상 25미만: 과체중
// 25이상: 비만
// 입니다. 9-25까지

import java.util.*;

public class Ex08BmiChecker {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("이름 입력");
        
        String name = scanner.nextLine();
        
        System.out.println("나이 입력");
        
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("키 입력");
        
        double height = scanner.nextDouble();//*0.01;
        scanner.nextLine();
        
        System.out.println("몸무게 입력");
        
        double weight = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.printf("이름 : %s 나이 : %d\n",name,age );
        System.out.printf("키 : %.2fM 몸무게 : %06.2fKg\n",height,weight);
        
        double BMI = weight / height / height;
        
        if(BMI < 18.5) {
            System.out.printf("BMI %.2f로 저체중",BMI);
        }else if(BMI <23) {
            System.out.printf("BMI %.2f로 정상체중",BMI);
        }else if(BMI <25) {
            System.out.printf("BMI %.2f로 과체중",BMI);
        }else {
            System.out.printf("BMI %.2f로 비만",BMI);
        }
        System.out.println("입니다.");
        
        scanner.close();
    }

}
