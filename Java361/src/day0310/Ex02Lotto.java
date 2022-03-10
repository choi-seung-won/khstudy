package day0310;

// 로또 번호 추첨기 ver 1.0
// 배열이아니라 int변수만 사용해서 만든 버전

import java.util.*;

public class Ex02Lotto {

    public static void main(String[] args) {

        // 가능한 로또 번호의 최소값
        final int LOTTO_MIN = 1;
        // 가능한 로또 번호의 최대값
        final int LOTTO_MAX = 45;

        // 랜덤숫자를뽑는데 사용할 random 클래스변수
        Random random = new Random();

        // 로또 번호를 저장할 int 변수 6개를 선언해보자
        int lotto1, lotto2, lotto3, lotto4, lotto5, lotto6;

        // int 변수 lotto1에 1부터 45사이의 랜덤한 숫자를 저장하자

        lotto1 = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        // int 변수 lotto2에 저장할 랜덤한 숫자를 뽑아보자.
        // 단, 이때에는 lotto1과 같은 숫자를 뽑을 시에 같은 숫자가 아닐 때까지
        // 다시 뽑는다.

        // 임시로 랜덤한 숫자를 저장할 int변수 temp
        int temp;

        // temp에 1~45사이의 랜덤한 숫자를 저장한다.

        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        // while을 통하여 temp가 lotto1과 같으면 다시 랜덤한 숫자를 뽑아서
        // temp에 저장한다
        while (temp == lotto1) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        }

        // temp의 현재 값을 lotto2에 저장한다.

        lotto2 = temp;

        // lotto3에 들어갈 숫자를 정한다.
        // 위에와 똑같은 방법을 쓰지만
        // 이번에는 lotto1,lotto2와 중복되지 않는 숫자를 뽑아서 저장한다.

        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        lotto3 = temp;

        // lotto4에 들어갈 숫자를 정한다.

        // 위에와 똑같은 방법을 쓰지만
        // 이번에는 lotto1, lotto2 , lotto3과 중복되지 않는 숫자를 뽑아서 저장한다.

        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        while (temp == lotto1 || temp == lotto2 || temp == lotto3) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        lotto4 = temp;

        // lotto5에 들어갈 숫자를 정한다.

        // 위에와 똑같은 방법을 쓰지만
        // 이번에는 lotto1, lotto2 , lotto3, lotto4와 중복되지 않는 숫자를 뽑아서 저장한다.

        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2 || temp == lotto3 || temp == lotto4) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        lotto5 = temp;

        // lotto6에 들어갈 숫자를 정한다.

        // 위에와 똑같은 방법을 쓰지만
        // 이번에는 lotto1, lotto2 , lotto3, lotto4, lotto 5와 중복되지 않는 숫자를 뽑아서 저장한다.

        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2 || temp == lotto3 || temp == lotto4 || temp == lotto5) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        lotto6 = temp;

        System.out.println("정렬 전 각 변수의 값");
        System.out.println("lotto1: " + lotto1);
        System.out.println("lotto2: " + lotto2);
        System.out.println("lotto3: " + lotto3);
        System.out.println("lotto4: " + lotto4);
        System.out.println("lotto5: " + lotto5);
        System.out.println("lotto6: " + lotto6);
        System.out.println("----------------------------");

        // 각 변수의 값을 이름에 맞춰서 오른차순 정렬해보자
        // 이때에는
        // 또 다른 6개의변수를 만들어서
        // 가장 작은 숫자부터 가장 큰 숫자를 찾아서
        // 원래 변수에 저장해야한다.

        // 1. 가장 작은 수 찾기
        int small1 = lotto1;

        // small1과 lotto2 , lotto3, lott4, lotto5 , lotto6을 비교해서
        // small1이 각 변수보다 크면
        // small1을 해당 변수의 값으로 바꿔준다.

        if (small1 > lotto2) {
            small1 = lotto2;
        }
        if (small1 > lotto3) {
            small1 = lotto3;
        }
        if (small1 > lotto4) {
            small1 = lotto4;
        }
        if (small1 > lotto5) {
            small1 = lotto5;
        }
        if (small1 > lotto6) {
            small1 = lotto6;
        }

        // small2의 값을 찾는다.
        // small2는 small1보다 크지만 그 다음으로 작은 숫 자를 찾게된다.

        int small2 = lotto1;

        if (small1 != lotto2 && small2 > small1 && small2 > lotto2) {
            small2 = lotto2;

        }

        if (small1 != lotto3 && small2 > small1 && small2 > lotto3) {
            small2 = lotto3;

        }

        if (small1 != lotto4 && small2 > small1 && small2 > lotto4) {
            small2 = lotto4;

        }

        if (small1 != lotto5 && small2 > small1 && small2 > lotto5) {
            small2 = lotto5;

        }

        if (small1 != lotto6 && small2 > small1 && small2 > lotto6) {
            small2 = lotto6;

        }

        int small3 = lotto1;

        if (small1 != lotto2 && small3 > small2 && small3 > lotto2) {
            small3 = lotto2;

        }

        if (small3 > small2 && small3 > lotto3) {
            small3 = lotto3;

        }

        if (small3 > small2 && small3 > lotto4) {
            small3 = lotto4;

        }

        if (small3 > small2 && small3 > lotto5) {
            small3 = lotto5;

        }

        if (small3 > small2 && small3 > lotto6) {
            small3 = lotto6;

        }

        int small4 = lotto1;

        if (small4 > small3 && small4 > lotto2) {
            small4 = lotto6;

        }

        if (small4 > small3 && small4 > lotto3) {
            small4 = lotto3;

        }

        if (small4 > small3 && small4 > lotto4) {
            small4 = lotto4;

        }

        if (small4 > small3 && small4 > lotto5) {
            small4 = lotto5;

        }

        if (small4 > small3 && small4 > lotto6) {
            small4 = lotto6;

        }
        
        int small5 = lotto1;

        if (small5 > small4 && small5 > lotto2) {
            small5 = lotto6;

        }

        if (small5 > small4 && small5 > lotto3) {
            small5 = lotto3;

        }

        if (small5 > small4 && small5 > lotto4) {
            small5 = lotto4;

        }

        if (small5 > small4 && small5 > lotto5) {
            small5 = lotto5;

        }

        if (small5 > small4 && small5 > lotto6) {
            small5 = lotto6;

        }
        
        int small6 = lotto1;

        if (small6 > small5 && small6 > lotto2) {
            small6 = lotto6;

        }

        if (small6 > small5 && small6 > lotto3) {
            small6 = lotto3;

        }

        if (small6 > small5 && small6 > lotto4) {
            small6 = lotto4;

        }

        if (small6 > small5 && small6 > lotto5) {
            small6 = lotto5;

        }

        if (small6 > small5 && small6 > lotto6) {
            small6 = lotto6;

        }
        // small1to6 출력결과
        System.out.println("정렬결과");
        System.out.println("small1: " + small1);
        System.out.println("small2: " + small2);
        System.out.println("small3: " + small3);
        System.out.println("small4: " + small4);
        System.out.println("small5: " + small5);
        System.out.println("small6: " + small6);

        
        
        // 별개의 변수 6개로 정렬을 하려 할 시 난이도가 높아짐.
        
        // 하지만 로또 번호같은 경우에는 우리가 굳이 특정 변수를 따로따로 만들 필요가 아예 없다.
        // 그렇다면 배열을 써서 만들면 어떨까
        
    }

}
