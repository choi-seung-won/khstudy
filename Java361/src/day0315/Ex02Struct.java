package day0315;
// 구조체(Struct)
// 구조체란 2세대 언어에서
// 여러가지 데이터타입을 모아서 하나의 새로운 데이터타입을 만드는 방법이다.
// 예를 들어서, 학생이란 데이터타입을 만들고 그 데이터타입 안에 번호, 이름,국어,영어,수학을 저장할
// 공간을 추가로 마련해주는 방법이다 .

import struct.Student;

public class Ex02Struct {
    
    public static void main(String[] args) {
        
        // 우리가 만든 Student "구조체" 변수를 선언과 초기화 할 때에는
        // 일반적인 클래스 변수 선언과 초기화를 할때와 코드가 똑같다.
        
        Student s = new Student();
        
        // 우리가 만든 student 구조체 변수 s에 각 공간에 값을 넣을 때는
        // s.~~~ = 값; 으로 넣는다.
        s.id = 3;
        s.name = "조재영";
        s.korean = 80;
        s.english = 81;
        s.math = 81;
        
        // 저장된 값을 불러올 때도 마찬가지로 s.~~~ 으로 불러오면 된다.
        
        System.out.println("s의 번호: "+ s.id);
        
        // 새로운 Student 변수 s2를 만들자
        Student s2 = new Student();
        // s2에 새로운 값을 넣어보자
        s2.id = 30;
        s2.name = "aaa";
        s2.korean = 90;
        s2.english = 91;
        s2.math = 91;
        
        // 새로운 Student 변수 s3을 만들자
        Student s3 = new Student();
        // s3에 s1의 값을 넣어보자.
        
        s3.id = 3;
        s3.name = "조재영";
        s3.korean = 80;
        s3.english = 81;
        s3.math = 81;
        
        // 질문 1: s와 s3는 같은공간입니까?
        // 아니요.
        // 개별적으로 new Student()로 초기화 도었으므로
        // 같은공간이 아니다.
        // 질문 2: s와 s3는 같은학생입니까?
        // 맞다.
        // 저장된공간이 다르나
        // id가 일치하므로 DB상 같은학생이다.(String을 생각하면 좋음).
        
        // 그렇다면 두 변수의 equals()는 결과값이 어떻게될까?
        System.out.println("s.equals(s3): " + s.equals(s3));
        // false
        // 클래스의 탈을 썼으나 "구조체" 의 단계이므로 equals가 부정확하게 나온다.
        // 따라서 2개의 Student변수가 같은지 확인할 때에는
        // 다음과 같이 해야한다.
        System.out.println("s.id == s3.id: "+ (s.id == s3.id));
        
    }

}
