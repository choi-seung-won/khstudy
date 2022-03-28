package day0328;
// 상속 02 - 인터페이스 상속
// 클래스 상속은 우리가 부모 클래스의 코드를 자식 클래스가 그대로 사용하기 위해 상속하였다.
// 하지만 인터페이스 상속은 그와는 좀 다른 목적을 위해 상속을 하게 된다.
// 인터페이스 상속은 오직 "다형성" 이라는 성질을 위해 사용하게 된다.

public class Ex01InterFace {
    public static void main(String[] args) {
        // 인터페이스형 객체는 반드시 인터페이스의 생성자가 아닌
        // 그 인터페이스를 상속받는 클래스의 생성자를 통해 초기화해야한다
        StudentInterface s = new MiddleStudent();
        
        s.printInfo();
    }

}
