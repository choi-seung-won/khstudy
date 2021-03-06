package day0315;

// 동적할당을 사용하는
// 학생 성적 입출력 프로그램을 작성하시오
// 단, 메인 메소드의 경우 코드를 최소화 시키시오.
import java.util.*;
import util.*;

public class Ex01GradeBook {

    public static final int STUDENT_SIZE = 5;
    public static final int SUBJECT_SIZE = 3;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    // 전역 변수
    // 1. 입력을 처리할 Scanner 클래스 변수
    public static Scanner scanner;
    // 2. 학생 번호를 저장할 배열
    public static int[] idArray;
    // 3. 학생 이름을 저장할 배열
    public static String[] nameArray;
    // 4. 학생의 국어점수를 저장할 배열
    public static int[] koreanArray;
    // 5. 학생의 영어점수를 저장할 배열
    public static int[] englishArray;
    // 6. 학생의 수학점수를 저장할 배열
    public static int[] mathArray;
    // 7. 다음 입력할 학생의 번호를 저장한 int nextId;
    public static int nextid;

    // 1. 각 전역 변수를 초기화해주는 init()
    public static void init() {
        scanner = new Scanner(System.in);

        idArray = new int[0];
        nameArray = new String[0];
        koreanArray = new int[0];
        englishArray = new int[0];
        mathArray = new int[0];
        nextid = 1;

    }
    // 2. init() 메소드를 호출하고 메뉴를 출력할
    // showMenu()

    public static void showMenu() {

        init();
        while (true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 3. 새로운 학생의 정보를 입력하는 insert()
    public static void insert() {

        // 1. 번호 입력
        //String message = "학생의번호를입력해주세요.";
        //int id = ScannerUtil.nextInt(scanner, message);
        //
        
        // 2. 이름 입력
        String message = "학생의이름을입력해주세요.";
        String name = ScannerUtil.nextLine(scanner, message);
        // 3. 국어 점수 입력
        message = "학생의국어점수를입력해주세요.";
        int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        // 4. 영어 점수 입력

        message = "학생의영어점수를입력해주세요.";
        int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        // 5. 수학 점수 입력

        message = "학생의수학점수를입력해주세요.";
        int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        // 6. 입력된 정보를 각 배열에 추가
        idArray = ArrayUtil.add(idArray, nextid++);
        //ArrayUtil.add가 배열의크기를 1 늘리고 가장 마지막칸에 새로운 요소를 추가함.
        nameArray = ArrayUtil.add(nameArray, name);
        koreanArray = ArrayUtil.add(koreanArray, korean);
        englishArray = ArrayUtil.add(englishArray, english);
        mathArray = ArrayUtil.add(mathArray, math);
    }

    // 4. 학생의 목록을 출력하는 printAll()
    public static void printAll() {
        // 만약 배열 중 한개가 비어있으면 경고 메세지만 출력하고
        // 그외는 for문을 사용하여 printOne()을 호출한다
        if(ArrayUtil.isEmpty(idArray)) {
            // 아직 입력된 학생이 존재하지 않으므로 메시지만 출력
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        }else {
            for(int i = 0 ; i < ArrayUtil.size(idArray); i++) {
                System.out.println("\n----------------------");
                System.out.printf("%d번째 학생 정보 \n", i + 1);
                System.out.println("========================");
                printOne(i);
                System.out.println("\n----------------------");
            }
        }
        
        
    }
    
    // 5. 개별 학생을 출력하는 printOne()

    public static void printOne(int index) {
        // 각 배열의 index번째 값을 변수에 저장한다.
        int id = ArrayUtil.get(idArray, index);
        String name = ArrayUtil.get(nameArray, index);
        int korean = ArrayUtil.get(koreanArray, index);
        int english = ArrayUtil.get(englishArray, index);
        int math = ArrayUtil.get(mathArray, index);

        // 번호 이름 출력

        System.out.printf("번호: %d번 이름: %s\n", id, name);

        // 국영수 점수 출력

        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);

        // 총점 평균 출력

        int sum = korean + english + math;
        double average = (double) sum / SUBJECT_SIZE;
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
    }



    public static void main(String[] args) {
        
        showMenu();
        
    }
        /*

        String message = "";
        idArray = new int[STUDENT_SIZE];
        nameArray = new String[STUDENT_SIZE];
        koreanArray = new int[STUDENT_SIZE];
        englishArray = new int[STUDENT_SIZE];
        mathArray = new int[STUDENT_SIZE];

        scanner = new Scanner(System.in);

        while (true) {

            message = "1.입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {

                if (currentIndex < STUDENT_SIZE) {

                    message = "%d번째 학생의 ID번호를 입력하시오" + currentIndex;
                    idArray[currentIndex] = ScannerUtil.nextInt(scanner, message);
                    message = "%d번째 학생의 이름을 입력하시오" + currentIndex;
                    nameArray[currentIndex] = ScannerUtil.nextLine(scanner, message);
                    message = "%d번째 학생의 국어점수를 입력하시오" + currentIndex;
                    koreanArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
                    message = "%d번째 학생의 영어점수를 입력하시오" + currentIndex;
                    englishArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
                    message = "%d번째 학생의 수학점수를 입력하시오" + currentIndex;
                    mathArray[currentIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

                    currentIndex++;
                }

            } else if (userChoice == 2) {

                for (int i = 0; i < currentIndex; i++) {

                    System.out.printf("%d번째 학생의 ID %d , 이름 %s ", i, idArray[i], nameArray[i]);
                    System.out.printf("국어점수 : %02d , 영어점수 : %02d , 수학점수 : %02d \n ", koreanArray[i], englishArray[i],
                            mathArray[i]);
                }

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;

            } else {
                System.out.println("잘못 입력하셨습니다.");
            }

        }
*/
    
}
