package day0311;

// 로또 번호 제작기 ver 3.0

//사용자로부터 로또 번호를 입력받아서
//정렬하여 출력해주는 프로그램.
//단, 1~45를 벗어나거나 중복된 숫자를 입력할 시에는
//사용자가 다시 입력하도록 프로그램코드를 작성하시오

//4-20
import java.util.*;

public class Ex02Lotto03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int MinNum = 1;
        final int MaxNum = 45;
        final int LotteryLength = 6;
        int[] LotteryNum = new int[LotteryLength];

        for (int i = 0; i < LotteryLength;) {
            System.out.printf("%d 번째 번호입력", i + 1);
            System.out.print("> ");
            int scantemp = scanner.nextInt();
            // 사용자가 입력한 값 temp가 올바르면 true,올바르지 않으면 false가 저장될 boolean변수선언 및 true로초기화
            boolean validSwitch = true;
            // 입력숫자가 번호숫자범위에 속하는지 체크, 속할경우 true 아닐경우 false
            validSwitch = scantemp >= MinNum && scantemp <= MaxNum;
            // jfor구문 사용하여 입력숫자가 중복인지 확인, 중복시 false
            for (int j = 0; j < i; j++) {
                // validSwitch에 저장된 값이 true이면
                // temp를 lottoNumbers 배열의 i번째 인덱스 칸에 저장하고
                // i 를 1 증가시킴
                // 만약 false이면
                // "범위를 벗어나거나 중복된 숫자입니다." 만 출력되게한다
                if (scantemp == LotteryNum[j]) {
                    validSwitch = false;
                }
            }
            if (validSwitch) {
                    LotteryNum[i] = scantemp;
                    i++;

                }else {
                    System.out.println("범위를 벗어나거나 중복된 숫자입니다.");
            }

        }
        // 정렬구문처리
        for (int i = 0; i < LotteryNum.length - 1; i++) {

            if (LotteryNum[i] > LotteryNum[i + 1]) {
                int temp = LotteryNum[i];

                LotteryNum[i] = LotteryNum[i + 1];

                LotteryNum[i + 1] = temp;
                i = -1;

            }

        }

        // 출력구문처리
        for (int i = 0; i < LotteryLength; i++) {

            System.out.printf("sorted num %d : [%2d] \n", i+1, LotteryNum[i]);
        }

    }

}

/*
 * for(int i = 0 ; i < LotteryNum.length - 1; i++) { if(LotteryNum[i] >
 * LotteryNum[i+1]) { int temp = LotteryNum[i]; LotteryNum[i]; = }
 * 
 * else if (LotteryNum[i] <= MaxNum || LotteryNum[i] < MinNum) {
 * System.out.println("범위를 벗어나거나 중복된 숫자입니다.");
 * 
 * } else {
 * 
 * LotteryNum[i] = scanner.nextInt(); scanner.nextLine();
 * 
 * scantemp = scanner.nextInt(); i++; } } }
 */
// 값 입력이 완료된 배열을 오름차순 정렬하는 i for문
