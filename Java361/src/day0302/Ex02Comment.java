package day0302;
// 주석(Comment)
// 우리가 자바 소스파일(.java 파일) 을 작성할 때에는
// 그 파일이 실행가능한 프로그램의 상태가 아직은 아니다.
// 우리가 소스파일을 저장하고 컴파일 이라는 단계를 거쳐야
// 자바 실행 환경(Java Runtime Environment)라는 가상 컴퓨터에서
// 실행 가능한 프로그램이 만들어진다.

// 우리가 실행 버튼을 누르면 이클립스가 자동으로 컴파일을 해주기 때문에
// 별도로 컴파일을 해줄 필요는 없다.

// 주석이란, 해당 소스파일을 컴파일 할때
// 변환이 되지 않는 글자들을 주석이라 칭함.

// 여러줄 주석은 /*로시작하고*/가 나오기 전까지의 모든 줄들을 주석으로 처리한다

public class Ex02Comment {

    public static void main(String [] args) {
        System.out.println("1");
        /*
        System.out.println("2");
        //System.out.println("3");
        System.out.println("4");
        */
        System.out.println("5");
    }
}
