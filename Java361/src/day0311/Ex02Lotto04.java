package day0311;
// 로또 번호 추첨기 ver 4.0

// 사용자가 숫자를 뽑으면
// 컴퓨터의 숫자들과 비교하여
// 사용자 숫자, 컴퓨터 숫자, 총 맞은 갯수를 출력해주는 버전

//5 - 20
// 고려해볼것 : [1,2,3,4,5,6]과 [2,3,4,5,6,7] 중 맞은 갯수를 찾는 방법

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ex02Lotto04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);

        final int MinNum = 1;
        final int MaxNum = 45;
        final int LotteryLength = 6;
        boolean matchChecker = false;

        // int[] LotteryNum = new int[LotteryLength];

        Random random = new Random();

        // 유저숫자배열
        int[] user_num_array = new int[LotteryLength];
        // 컴퓨터숫자배열 

        int[] cpu_num = ThreadLocalRandom.current().ints(LotteryLength, MinNum, MaxNum).toArray();
        //컴퓨터배열에 로또번호 저장
        
        /*
         * int[] cpu_num = new int[LotteryLength];
         * for(int i = 0 ; i <computerNumbers.length;){
         * int temp = random.nextInt(LotteryLength) + MinNum;
         * 
         * boolean numberswitch = true
         * 
         * for(int j = 0; j < i; j++){
         * if(temp == computerNumbers[j]{
         * numberSwitch = false;
         * }
         * }
         * 
         * if(numberSwitch){
         * computerNumbers[i]=temp;
         * i++;
         * 
         * 컴퓨터숫자정렬
         * 
         * for(int i = 0 ; i < computerNumbers.length - 1 ; i ++){
         * if(computerNumbers[i] > computerNumbers[i+1]){
         * int temp = computerNumbers[i];
         * computerNumbers[i] = computerNumbers[i+1];
         * computerNumbers[i+1] = temp;
         * i = -1;
         */
        for(int i = 0 ; i < cpu_num.length - 1 ; i ++){
             if(cpu_num[i] > cpu_num[i+1]){
             int temp = cpu_num[i];
             cpu_num[i] = cpu_num[i+1];
             cpu_num[i+1] = temp;
             i = -1;
             }
        }
        // 유저측구문
        for (int i = 0; i < LotteryLength;) {

            System.out.printf("%d번 숫자를 뽑으시오. \n", i+1);
            System.out.print(">");
            
            int temp = scanner.nextInt();

            boolean validSwitch = temp >= MinNum && temp <=MaxNum;
            
            for ( int j = 0 ; j < i ; j ++) {
                if(temp == user_num_array[j]) {
                    validSwitch= false;
                }
            }
            if(validSwitch) {
                user_num_array[i]=temp;
                i++;
            }else {
                System.out.println("잘못입력했습니다.");
            }
            //user_num_array[i] = random.nextInt();
        }

        // 정렬구문

        for (int i = 0; i < user_num_array.length - 1; i++) {

            if (user_num_array[i] > user_num_array[i + 1]) {

                int temp = user_num_array[i];

                user_num_array[i] = user_num_array[i + 1];

                user_num_array[i + 1] = temp;
                i = -1;

            }
        }
            //배열비교 후 중복숫자의 갯수를 int변수저장
            int count = 0;
            for(int i = 0 ; i < user_num_array.length; i ++) {
                for(int j = 0 ; j < cpu_num.length; j ++) {
                    if(user_num_array[i] == cpu_num[j]) {
                        count ++ ;
                    }
                }
            }
            
            // 결과 출력
            System.out.print("컴퓨터의숫자: [");
            for(int i = 0 ; i <cpu_num.length; i ++) {
                System.out.printf("%2d", cpu_num[i]);
                if(i<cpu_num.length - 1) {
                    System.out.print(", ");
                }else {
                    System.out.println("]");
                }
            }
            System.out.printf("사용자의 숫자: [");
            for(int i = 0; i <user_num_array.length; i++) {
                System.out.printf("%2d",user_num_array[i]);
                if(i < user_num_array.length -1) {
                    System.out.print(", ");
                }else {
                    System.out.println("]");
                }
            }
            
            System.out.println("총맞은갯수: " + count);

    }

}
