package day0310;

import java.util.Random;

public class Ex02Lotto {
    public static void main(String[] args) {
        // 상수
        // 1. 로또의 가능한 최소값
        final int LOTTO_MIN = 1;
        // 2. 로또의 가능한 최대값
        final int LOTTO_MAX = 45;

        // 랜덤 숫자를 뽑을 Random 클래스 변수
        Random random = new Random();

        // 1. 랜덤 숫자를 저장할 변수 선언
        int lotto1, lotto2, lotto3, lotto4, lotto5, lotto6;

        // 2. int 변수 temp에 랜덤 숫자 저장
        int temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        // 3. temp의 현재 값을 lotto1에 저장
        lotto1 = temp;

        // 4. temp에 랜덤 숫자 저장 후 lotto1과 같은 동안 새로운 랜덤 숫자를 저장
        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        // 5. temp의 현재 값을 lotto2에 저장
        lotto2 = temp;

        // 6. temp에 랜덤 숫자 저장 후 lotto1 혹은 lotto2와 같은 동안 새로운 랜덤 숫자를 저장
        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        // 7. temp의 현재 값을 lotto3에 저장
        lotto3 = temp;

        // 8. temp에 랜덤 숫자 저장 후 lotto1 혹은 lotto2 혹은 lotto3과 같은 동안 새로운 랜덤 숫자를 저장
        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2 || temp == lotto3) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        // 9. temp의 현재 값을 lotto4에 저장
        lotto4 = temp;

        // 10. temp에 랜덤 숫자 저장 후 lotto1 혹은 lotto2 혹은 lotto3 혹은 lotto4와 같은 동안 새로운 랜덤 숫자를
        // 저장
        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2 || temp == lotto3 || temp == lotto4) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        // 11. temp의 현재 값을 lotto5에 저장
        lotto5 = temp;

        // 12. temp에 랜덤 숫자 저장 후 lotto1 혹은 lotto2 혹은 lotto3 혹은 lotto4 혹은 lotto5와 같은 동안
        // 새로운 랜덤 숫자를 저장
        temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

        while (temp == lotto1 || temp == lotto2 || temp == lotto3 || temp == lotto4 || temp == lotto5) {
            temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
        }

        // 13. temp의 현재 값을 lotto6에 저장
        lotto6 = temp;

        // 14. 정렬 전 중간단계 출력
        System.out.println("--------------------------------------------------------");
        System.out.println("정렬 전 중간 단계");
        System.out.println("--------------------------------------------------------");
        System.out.println("lotto1: " + lotto1);
        System.out.println("lotto2: " + lotto2);
        System.out.println("lotto3: " + lotto3);
        System.out.println("lotto4: " + lotto4);
        System.out.println("lotto5: " + lotto5);
        System.out.println("lotto6: " + lotto6);
        System.out.println("--------------------------------------------------------\n");

        // 15. 정렬된 결과를 저장할 int 변수 선언하고 최대값 보다 큰 값으로 초기화
        // 최대값 보다 큰 값으로 초기화하는 이유는
        // 더 작은 값을 찾는 if 구조에서 45가 나오더라도
        // 조건식이 true가 나오게 위함이다.
        int small1 = LOTTO_MAX + 1;
        int small2 = LOTTO_MAX + 1;
        int small3 = LOTTO_MAX + 1;
        int small4 = LOTTO_MAX + 1;
        int small5 = LOTTO_MAX + 1;
        int small6 = LOTTO_MAX + 1;

        // 16. small1에 lotto1 저장
        small1 = lotto1;

        // 17. small1과 lotto2~lotto6를 비교하여 small1의 현재 값보다 더 작은 값을 small1에 저장
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

        // 18. small1이 lotto1과 다르면 sm1ll2에 lotto1 저장
        if (small1 != lotto1) {
            small2 = lotto1;
        }

        // 19. small2와 lotto2~6을 비교하여 lotto2~lotto6가 small1과 다르고 small2의 현재 값보다 더 작은 값을
        // small2에 저장

        if (small1 != lotto2 && small2 > lotto2) {
            small2 = lotto2;
        }

        if (small1 != lotto3 && small2 > lotto3) {
            small2 = lotto3;
        }

        if (small1 != lotto4 && small2 > lotto4) {
            small2 = lotto4;
        }

        if (small1 != lotto5 && small2 > lotto5) {
            small2 = lotto5;
        }

        if (small1 != lotto6 && small2 > lotto6) {
            small2 = lotto6;
        }

        // 20. small1 혹은 small2가 lotto1과 다르면 small3에 lotto1 저장
        if (small1 != lotto1 && small2 != lotto1) {
            small3 = lotto1;
        }

        // 21. small3과 lotto2~6을 비교하여 lotto2~lotto6가 small1 혹은 small2와 다르고 small3의 현재
        // 값보다 더 작은 값을
        // small3에 저장

        if (small1 != lotto2 && small2 != lotto2 && small3 > lotto2) {
            small3 = lotto2;
        }

        if (small1 != lotto3 && small2 != lotto3 && small3 > lotto3) {
            small3 = lotto3;
        }

        if (small1 != lotto4 && small2 != lotto4 && small3 > lotto4) {
            small3 = lotto4;
        }

        if (small1 != lotto5 && small2 != lotto5 && small3 > lotto5) {
            small3 = lotto5;
        }

        if (small1 != lotto6 && small2 != lotto6 && small3 > lotto6) {
            small3 = lotto6;
        }

        // 22. small1 혹은 small2 혹은 small3이 lotto1과 다르면 small4에 lotto1 저장
        if (small1 != lotto1 && small2 != lotto1 && small3 != lotto1) {
            small4 = lotto1;
        }

        // 23. small4와 lotto2~6을 비교하여 lotto2~lotto6가 small1 혹은 small2 혹은 small3과 다르고
        // small4의 현재
        // 값보다 더 작은 값을
        // small4에 저장

        if (small1 != lotto2 && small2 != lotto2 && small3 != lotto2 && small4 > lotto2) {
            small4 = lotto2;
        }

        if (small1 != lotto3 && small2 != lotto3 && small3 != lotto3 && small4 > lotto3) {
            small4 = lotto3;
        }

        if (small1 != lotto4 && small2 != lotto4 && small3 != lotto4 && small4 > lotto4) {
            small4 = lotto4;
        }

        if (small1 != lotto5 && small2 != lotto5 && small3 != lotto5 && small4 > lotto5) {
            small4 = lotto5;
        }

        if (small1 != lotto6 && small2 != lotto6 && small3 != lotto6 && small4 > lotto6) {
            small4 = lotto6;
        }

        // 24. small1 혹은 small2 혹은 small3 혹은 small4가 lotto1과 다르면 small5에 lotto1 저장
        if (small1 != lotto1 && small2 != lotto1 && small3 != lotto1 && small4 != lotto1) {
            small5 = lotto1;
        }

        // 25. small4와 lotto2~6을 비교하여 lotto2~lotto6가 small1 혹은 small2 혹은 small3 혹은
        // small4와 다르고 small5의 현재 값보다 더 작은 값을
        // small5에 저장

        if (small1 != lotto2 && small2 != lotto2 && small3 != lotto2 && small4 != lotto2 && small5 > lotto2) {
            small5 = lotto2;
        }

        if (small1 != lotto3 && small2 != lotto3 && small3 != lotto3 && small4 != lotto3 && small5 > lotto3) {
            small5 = lotto3;
        }

        if (small1 != lotto4 && small2 != lotto4 && small3 != lotto4 && small4 != lotto4 && small5 > lotto4) {
            small5 = lotto4;
        }

        if (small1 != lotto5 && small2 != lotto5 && small3 != lotto5 && small4 != lotto5 && small5 > lotto5) {
            small5 = lotto5;
        }

        if (small1 != lotto6 && small2 != lotto6 && small3 != lotto6 && small4 != lotto6 && small5 > lotto6) {
            small5 = lotto6;
        }

        // 26. small1 혹은 small2 혹은 small3 혹은 small4 혹은 small5가 lotto1과 다르면 small6에
        // lotto1 저장
        if (small1 != lotto1 && small2 != lotto1 && small3 != lotto1 && small4 != lotto1 && small5 != lotto1) {
            small6 = lotto1;
        }

        // 27. small4와 lotto2~6을 비교하여 lotto2~lotto6가 small1 혹은 small2 혹은 small3 혹은
        // small4 혹은 small5와 다르고 small5의 현재 값보다 더 작은 값을
        // small5에 저장

        if (small1 != lotto2 && small2 != lotto2 && small3 != lotto2 && small4 != lotto2 && small5 != lotto2 && small6 > lotto2) {
            small6 = lotto2;
        }

        if (small1 != lotto3 && small2 != lotto3 && small3 != lotto3 && small4 != lotto3 && small5 != lotto3 && small6 > lotto3) {
            small6 = lotto3;
        }

        if (small1 != lotto4 && small2 != lotto4 && small3 != lotto4 && small4 != lotto4 && small5 != lotto4 && small6 > lotto4) {
            small6 = lotto4;
        }

        if (small1 != lotto5 && small2 != lotto5 && small3 != lotto5 && small4 != lotto5 && small5 != lotto5 && small6 > lotto5) {
            small6 = lotto5;
        }

        if (small1 != lotto6 && small2 != lotto6 && small3 != lotto6 && small4 != lotto6 && small5 != lotto6 && small6 > lotto6) {
            small6 = lotto6;
        }

        // 14. 정렬 후 최종 결과 출력
        System.out.println("--------------------------------------------------------");
        System.out.println("정렬 후 최종 결과");
        System.out.println("--------------------------------------------------------");
        System.out.println("small1: " + small1);
        System.out.println("small2: " + small2);
        System.out.println("small3: " + small3);
        System.out.println("small4: " + small4);
        System.out.println("small5: " + small5);
        System.out.println("small6: " + small6);
        System.out.println("--------------------------------------------------------\n");
    }
}
