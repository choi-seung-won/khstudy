package day0302;
// 상수(Constant)
// 변수와 마찬가지로 상수도 값을 저장하는 공간이지만,
// 차이점은 상수는 딱 한번만 값을 저장할수 있다.

// 상수는 다음과 같은 형태로 선언한다.
// final 데이터타입 상수이름;

public class Ex05Constant {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // int 상수 NUMBER를 선언해보자
        final int NUMBER;
        // NUMBER에 20을 할당
        NUMBER=20;
        
        System.out.println(NUMBER);
        
        //NUMBER에 30을 할당
        //NUMBER = 30; The final local variable NUMBER may already have been assigned
        

    }

}
