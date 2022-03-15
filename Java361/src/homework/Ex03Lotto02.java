package homework;

import util.ArrayUtil;
//ArrayUtil을 사용하여
//동적할당이 적용된 컴퓨터 로또 번호 추첨기를 만드시오.
// 심화) 또한 다양한 메소드를 만들어서 사용자가 여러게임을 하는 경우도 대비하시오.
import util.ScannerUtil;
import java.util.*;

public class Ex03Lotto02 {

    public static int[] computerNumbers;

    // 사용자의 게임들을 담을 int 2차원배열
    public static int[][] userNumbers;
    // 3. 입력에서 사용할 Scanner 클래스 변수
    public static Scanner scanner;

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int MAX_LENGTH = 6;

    public static void main(String[] args) {
        // 0 . 입력에 사용할 scanner 전역변수 초기화
        scanner = new Scanner(System.in);

        // 1. computerNumbers를 길이가 0 인 배열로 초기화한다.
        computerNumbers = new int[0];
        // 2. computerNumbers에 중복되지 않는 랜덤숫자를

        // 메소드를 사용하여 추가한다.
        computerNumbers = insertRandomNum();
        // 3. computerNumbers의 저장된 값을
        // 메소드를 사용하여 오름차순 정렬한다.
        sort(computerNumbers);

        // 4. 사용자로부터 총 몇게임을 할 지 입력받아서 2차원배열의 길이를 지정한다.
        int gameSize = ScannerUtil.nextInt(scanner, "총 몇게임을 하시겠습니까?");

        userNumbers = new int[gameSize][0];

        // 5. 각 게임마다 자동인지 수동인지를 입력 받아서
        // 각각에 따른 메소드를 실행시킨다
        setMode();
        // 6. 메소드를 사용하여 결과를 출력한다.
        printResult();

    }

    // 배열에 MAX_LENGTH 만큼의 랜덤숫자를 추가하는
    // insertRandomNum()

    public static int[] insertRandomNum() {
        // while문을 사용하여
        // 특정 배열의 크기가MAX_LENGTH 보다 작을동안
        // 중복되지 않는 숫자를 해당 배열에 추가한다.
        // 랜덤 숫자를 담을 int배열선언 및 초기화
        int[] array = new int[0];
        // 랜덤 숫자를 뽑을 때 사용한 Random 클래스 변수
        Random random = new Random();

        while (ArrayUtil.size(array) < MAX_LENGTH) {

            // int temp에 1~45사이의 랜덤 숫자 지정
            int temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

            // 만약 array에 temp가 존재하지 않는다면
            // array에 temp 추가

            if (!ArrayUtil.contains(array, temp)) {
                array = ArrayUtil.add(array, temp);
            }

        }
        return array;
    }

    // int 배열에 저장된 값을 오름차순 정렬하는
    // sort(int[])
    public static void sort(int[] array) {
        for (int i = 0; i < ArrayUtil.size(array) - 1; i++) {
            if (ArrayUtil.get(array, i) > ArrayUtil.get(array, i + 1)) {
                ArrayUtil.set(array, i + 1, ArrayUtil.set(array, i, ArrayUtil.get(array, i + 1)));
                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 배열을 출력하는 메소드
    public static void printArray(int[] array) {
        for (int i = 0; i < ArrayUtil.size(array); i++) {
            System.out.printf("%d", ArrayUtil.get(array, i));
            if (i != ArrayUtil.size(array) - 1) {
                System.out.print(", ");
            }
        }
    }

    // 사용자로부터 입력을 받아서
    // 각게임을 자동으로 할지 수동으로 할지 결정하는 메소드
    public static void setMode() {
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.printf("%d번째 게임\n", i + 1);
            String message = "1.자동 2.수동";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                // 사용자가 자동을 선택했을 때
                userNumbers[i] = insertRandomNum();
            } else if (userChoice == 2) {
                // 사용자가 수동을 선택했을 때
                userNumbers[i] = insertNum();
            }
            
            // userNumbers의 i번째 배열을 sort()를 사용하여 정렬한다.
            sort(userNumbers[i]);
        }
    }

    // 사용자가 수동을 선택했을 경우
    // 사용자가 입력한 유효한 숫자를 배열에 저장하는 메소드

    public static int[] insertNum() {
        // 사용자가 입력한 숫자를 저장할 배열
        int[] array = new int[0];

        // 지금 몇번째 숫자를 입력할 차례인지
        // 알려줄 때 사용할 count 변수
        int count = 1;

        while (ArrayUtil.size(array) < MAX_LENGTH) {

            System.out.println("-------------------");
            System.out.println(count + "번째 숫자");
            System.out.println("-------------------\n");
            String message = count + "번째 숫자를 입력해주세요.";

            int temp = ScannerUtil.nextInt(scanner, message, LOTTO_MIN, LOTTO_MAX);
            if( !(ArrayUtil.contains(array, temp))) {
                array = ArrayUtil.add(array, temp);
                count++;
            }else {
                System.out.println("해당 숫자는 중복된 숫자입니다.");
            }
        }

        return array;
    }
    
    // 결과를 출력하는 printResult()
    
    public static void printResult() {
        // 1. 컴퓨터 배열을 출력
        
        System.out.println("\n============================");
        System.out.println("컴퓨터의 숫자");
        System.out.println("============================\n");
        System.out.print("[");
        printArray(computerNumbers);
        System.out.println("]");
        
        // 2. 사용자 배열의 각 배열과 맞은 갯수를 출력
        System.out.println("\n============================");
        System.out.println("사용자의 숫자");
        System.out.println("============================\n");
        for(int i = 0; i < userNumbers.length; i ++) {
            System.out.print((i+1)+"번 게임: [");
            printArray(userNumbers[i]);
            System.out.println("] - 총 맞은 갯수: " + countSameNum(computerNumbers, userNumbers[i]));
        }
        
    }
    
    // 두개의 배열을 비교해서 총 맞은 갯수를 리턴하는
    // countSameNum()
    
    public static int countSameNum(int[] array1 , int[] array2) {
        
        int count = 0;
        
        for(int i = 0 ; i<ArrayUtil.size(array1); i ++) {
            for(int j = 0 ; j < ArrayUtil.size(array2); j ++) {
                if(ArrayUtil.get(array1, i) == ArrayUtil.get(array2, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
