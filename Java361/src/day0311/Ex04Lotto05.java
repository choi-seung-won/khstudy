package day0311;
// 로또 번호 추첨기 ver5
// 사용자가 한번에 한게임만 하는 것이 아니라
// 사용자가 지정한 횟수의 게임을 할 수 있게 코드를 작성하시오.

// 단 , 각 게임을 사용자가 매번 수동 입력을 하는것이 아니라
// 1. 자동 2. 수동중에 하나 선택해서
// 자동을 선택하면 해당 게임은 숫자가 자동으로 배정이 되고
// 수동을 선택하면 해당 게임은 사용자가 직접 숫자를 배정하게 만드시오.

// 또한 결과창에서는 사용자의 각 게임옆에 맞은 갯수를 같이 출력해주시오.
// 7 - 30

import java.util.*;

public class Ex04Lotto05 {
    
    public static void main(String[] args) {
    
        
        Scanner scanner = new Scanner(System.in);
    
        final int MinNum = 1;
        final int MaxNum = 45;
        final int LotteryLength = 6;
        
        //게임횟수지정 및 변수선언
        
        int gameloop;
        //컴퓨터의 숫자를 저장할 int1차원 배열
        int[] cpu_num = new int[LotteryLength];
        
        
        //유저의 숫자를 저장할 int1차원 배열
        int[][] user_num_array;
        
        System.out.println("게임횟수 입력");
        System.out.print("> ");
        gameloop = scanner.nextInt();
        scanner.nextLine();
        Random random = new Random() ;
        
        
        user_num_array = new int[gameloop][LotteryLength];
        
        /*for(int i = 0 ; i < computerNumbers.length;){
         * int temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
         * BOOLEAN validSwitch = true;
         * for(int j = 0 ; j < i ; j ++){
         * if( temp == computerNumbers[j]){
         * validSwitch = false;
         * }
         * }
         * if ( validSwitch){
         * computerNumbers[i] = temp;
         * i++;
         * }
         * }
         * 
         * computerNumbers를 오름차순 정렬
         * for ( int i = 0 ; i < computerNumbers.length - 1 ; i ++){
         * if(computerNumbers[i] > computerNumbers[i + 1 ] ){
         * int temp = computerNumbers[i];
         * computerNumbers[i] = computerNumbers[i+1];
         * computerNumbers[i+1] = temp;
         * i = -1;
         * }
         * }
         * 
         * 사용자로부터 각게임을 자동으로할지 수동으로할지 입력받아서 각각에 맞는 코드를 작성해준다.
         * for ( int i = 0 ; i < userNumbers.length; i++){
         * 
         * sysout ((i+1)+"번째 게임") ; 
         * sysout ("====================");
         * 
         * sysout ("1.자동 2.수동");
         * sysoutf ">" ;
         * int userChoice = scanner.nextInt();
         * 임시숫자가 유효한 숫자인지를 저장할 boolean변수선언
         * boolean validSwitch;
         * 
         * if(userChoice == 1){
         * 임시숫자를 저장할 int 변수선언
         * int temp
         * i 번째 배열에 자동으로 숫자 배정
         * for ( int j = 0 ; j < userNumbers[i].length;){
         * validSwitch = true
         * temp = random.nextInt(LOTTOMAX) + LOTTOMIN;
         * for ( int k = 0 ; k < j ; k ++){
         * if (temp == userNumbers[i][k]{
         * validSwitch = false
         * }
         * }
         * if(validSwitch){
         * userNumbers[i][j] = temp;
         * j++;
         * }
         * }
         * }
         * else{
         * i번째 배열에 사용자가 입력한 숫자를 배정
         * for ( int j = 0 ; j < userNumbers[i].length;){
         *      //사용자로부터 숫자를 입력 받는다.
         *      sysout f ("%d번재 숫자를 입력해주세요. \n " , j + 1 ) ;
         *      sysout ("> ");
         *      temp = scanner.nextInt();
         *      
         *      validSwitch = temp >= LOTTO_MIN && temp <= LOTTO_MAX;
         *      for(int k = 0 ; k < j ; k ++){
         *      if(temp == userNumbers[i][k]){
         *      validSwitch = false;
         *      }
         *      }
         *      if ( validSwitch ) {
         *      userNumbers[i][j] = temp;
         *      j ++;
         *      }else{
         *      sysout ("잘못입력하셨습니다.");
         * 
         *  }
         * }
         * }
         * }
         * 
         * userNumbers 2차원 배열의 각 배열을 오름차순 정렬한다.
         * for(int i = 0 ; i < userNumbers.length ; i ++){
         *      
         *      for(int j = 0 ; j <userNumbers[i].length - 1 ; j ++){
         *      if(userNumbers[i][j]> userNumbers[i][j+1]){
         *      int temp = userNumbers[i][j];
         *      userNumbers[i][j] = userNumbers[i][j+1];
         *      userNumbers[i][j+1] = temp;
         *      j = -1;
         * }
         * }
         * }
         * 
         *결과출력
         *각 게임의 맞은 갯수를 저장할 int[] count
         *int [] count = new int[gameNumber];
         *
         *computerNumbers와 userNumbers의 각 배열의 같ㅇ느 숫자를 센다.
         *for ( int i = 0 ; i < userNumbers.length ; i ++){
         *      for( int j = 0 ; j < userNumbers[i].length; j ++){
         *          for(int k = 0 ; k < computerNumbers.length; k ++){
         *          if(userNumbers[i][j] == computerNumbers[k] ){
         *          count[i]++;
         *          }
         *          }
         *      }
         *      
         *  }
         *
         * computernumbers출력
         * sysout ("\n==");
         * sysout ("당첨번호");
         * sysout ("\n==");
         * sysout ("[");
         * for(int i = 0; i < computerNumbers.length; i ++){
         * sysoutf ("%2d", computerNumbers[i]);
         * if(i ! = computerNumbers.length - 1 ){
         * sysout (", " );
         * }
         * else{
         * sysout ("]");
         * }
         * }
         * }
         * 사용자의 각게임숫자와 해당 게임의 정답갯수 출력
         * 
         * sysout "=="
         * sysout "사용자결과
         * sysout "=="
         * 
         * for(int i = 0 ; i < userNumbers.length ; i ++){
         * sysout "["
         * 
         * 
         * for( int j = 0 ; j <userNumbers[i].length ; j ++){
         * sysout f "%2d" , userNumbers[i] [j] ;
         * if ( j != userNumbers[i].length - 1) {
         * sysout f ", " ;
         * 
         * }else {
         * sysout "] - 총맞은갯수 : " + count[i] + "개");
         * }
         * 
         * }
         * 
         * }
         * }
         * 
         * 
         */
        
        for(int i = 1 ;i < gameloop ; i ++) {
            
            System.out.println("자동(1) 또는 수동(2) 선택 ");
            System.out.print("> ");
            
            int gametype = scanner.nextInt();
            scanner.nextLine();
  
            //new int [gameloop][LotteryLength];

            if( gametype == 1) {
                //컴퓨터난수배열정리(gametype1,2무관,통합)
                for(int j = 0 ; j < cpu_num.length;) {
                    int temp = random.nextInt(LotteryLength) + MinNum;
                    boolean numberswitch = true;
                    
                    for(int k = 0 ; k < j ; k ++) {
                        if(temp == cpu_num[k]) {
                            numberswitch = false;
                        }
                    }
                    if(numberswitch) {
                        cpu_num[j] = temp ; 
                        j ++;
                    }
                }
                //컴퓨터난수배열 정렬 bubble sort
                for ( int j = 0 ; j <cpu_num.length - 1; j ++) {
                    if(cpu_num[i] > cpu_num[i+1]) 
                    {
                        int temp = cpu_num[i];
                        cpu_num[i] = cpu_num[i+1];
                        cpu_num[i+1] = temp;
                        i = -1;
                    }
                }
                //통합 여기까지
                
                ///temp수정해야함
                
                //유저 난수배열
                //수정시작
                for(int j = 0 ; j < user_num_array[i].length;) {
                    int temp = random.nextInt(LotteryLength) + MinNum;
                    boolean numberswitch = true;
                    
                    for(int k = 0 ; k < j ; k ++) {
                        if(temp == user_num_array[i][k]) {
                            numberswitch = false;
                        }
                    }
                    if(numberswitch) {
                        user_num_array[i][j] = temp ; 
                        j ++;
                    }
                }
                //컴퓨터난수배열 정렬 bubble sort
                for ( int j = 0 ; j <user_num_array.length - 1; j ++) {
                    if(user_num_array[i][j] > user_num_array[i][j+1]) 
                    {
                        int temp = user_num_array[i][j];
                        user_num_array[i][j] = user_num_array[i][j+1];
                        user_num_array[i][j+1] = temp;
                        i = -1;
                    }
                }
            }else if ( gametype == 2) {
                
            }else {
                System.out.println("잘못된 값이므로 다시 입력");
            }
            int count = 0;
            
            for( int j = 0 ; j < user_num_array.length; j ++) {
                for(int k = 0 ; k <cpu_num.length; k ++) {
                    if(user_num_array[i][j] == cpu_num[k]) {
                        count ++;
                    }
                }
            }
            // 출력구문
            
            System.out.println("컴퓨터의 숫자: [");
            for(int j = 0 ; j < cpu_num.length; j ++) {
                System.out.printf("%2d", cpu_num[j]);
                if(j < cpu_num.length - 1) {
                    System.out.print(" , ");
                }else {
                    System.out.println("]");
                }
                
            }
            
            System.out.print("사용자의 숫자: [");
            for(int j = 0 ; j < user_num_array.length ; j++) {
                System.out.printf("%2d", user_num_array[j]);
            if ( j < user_num_array.length - 1) {
                System.out.println(", ");
            }else {
                System.out.println("]");
            }
        }
            System.out.println("스코어: " + count);
    
    }
    
    

}
}