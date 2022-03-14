package homework;
// 입력 , 출력 , 종료 기능을 가지고 있는

// 학생 성적 출력 프로그램을 만드시되 , 
// 점수를 사용자가 입력하면 올바른 점수를 리턴해주는 메서드를 만들어서
// 국어, 영어 , 수학 점수를 입력 받을때 해당 메서드를 사용하시고
// 출력도 별개의 메서드로 분리해서 프로그램을 작성하시오

import java.util.*;

public class Ex01GradeBook {

    public static void main(String[] args) {
        // 입력에서 사용할 scanner클래스 변수
        Scanner scanner = new Scanner(System.in);
        // 각정보를저장할변수

        int korean = 0;
        int english = 0;
        int math = 0;
        String name = "";
        int id = 0;

        boolean inputSwitch = false;

        // 무한루프를 사용한 메뉴 출력
        while (true) {
            System.out.println("1.입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                // 입력코드구현
                // 번호입력
                System.out.println("번호를입력해주세요");
                System.out.print("> ");
                id = scanner.nextInt();
                // 이름입력
                System.out.println("이름을입력해주세요");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();
                // 국어점수입력
                korean = setScore(scanner, "국어");

                // 영어점수입력
                english = setScore(scanner, "영어");

                // 수학점수입력

                math = setScore(scanner, "수학");

                // inputSwitch에 true저장
                inputSwitch = true;

            } else if (userChoice == 2) {
                
                //출력코드구현
                if(inputSwitch) {
                    printInfo(id, name, korean, english, math);
                }else {
                    System.out.println("아직입력된정보가존재하지않습니다");
                }

            } else if (userChoice == 3) {
                // 메세지출력후종료
                System.out.println("사용해주셔서감사합니다.");
                break;
            }
        }

        score_export(math, english, korean);

    }

    public static double score_export(int math, int english, int korean) {

        return math + english + korean / 3.0;

    }

    public static int setScore(Scanner scanner, String subject) {
        // 상수
        // 1.가능한 최소점수
        final int SCORE_MIN = 0;
        // 2.가능한 최대점수
        final int SCORE_MAX = 100;

        int score = 0;
        System.out.println(subject + "점수를 입력해주세요.");
        System.out.print("> ");

        score = scanner.nextInt();
        while (!(score >= SCORE_MIN && score <= SCORE_MAX)) {
            System.out.println("잘못입력하셨습니다.");
            System.out.println(subject + "점수를 입력해주세요.");
            System.out.print("> ");
            score = scanner.nextInt();
        }
        return score;
    }

    public static void printInfo(int id, String name, int korean, int english, int math) {

        //상수
        //과목의갯수
        final int SUBJECT_SIZE = 3;
        
        //번호이름출력
        System.out.printf("번호 : %03d번 ,이름 : %s\n", id, name);
        //국영수점수출력
        System.out.printf("국어 : %03d점 , 영어 : %03d점 수학 : %03d점", korean , english , math);
      
        
        //총점평균출력
        int sum = korean + english + math;
        double average = (double)sum / SUBJECT_SIZE ; 
        System.out.printf("총점: %03d점 평균: %06.2f점\n",sum , average);
    }
}

/*
 * public static int score_input(int korean, int english ,int math){
 * 
 * sysout > int subject*3 scanner.nextint line
 * 
 * return
 * 
 * 
 * }
 */
