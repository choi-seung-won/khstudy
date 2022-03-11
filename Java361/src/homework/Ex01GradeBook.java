package homework;
// 입력 , 출력 , 종료 기능을 가지고 있는
// 학생 성적 출력 프로그램을 만드시되 , 
// 점수를 사용자가 입력하면 올바른 점수를 리턴해주는 메서드를 만들어서
// 국어, 영어 , 수학 점수를 입력 받을때 해당 메서드를 사용하시고
// 출력도 별개의 메서드로 분리해서 프로그램을 작성하시오


import java.util.*;
public class Ex01GradeBook {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("수학점수입력");
        System.out.print("> ");
        
        int userInput_math = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("영어점수입력");
        System.out.print("> ");
        
        int userInput_english = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("국어점수입력");
        System.out.print("> ");
        int userInput_korean = scanner.nextInt();
        scanner.nextLine();
        
        score_export(userInput_math,userInput_english,userInput_korean);
        
        

    }
    
    public static double score_export(int math , int english , int korean) {
        
        return  math + english + korean / 3.0;
        
        
    }
    
    public static String result(String ) {
        System.out.printf("국어점수 : %d , 영어점수 : %d 수학점수 : %d" , korean,english,math);
        
        
    }

}
