package day0303;

// 기본형 데이터타입 변수를 만들고 값을 저장하고 호출해보는 예제
public class Ex05PrimitiveTypes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("1. 정수형 데이터타입");

        // byte 데이터타입의 변수 myByte를 선언하고 20을 넣어보자
        byte myByte = 20;
        // 화면에 myByte의 현재 값을 출력해보자

        System.out.println(myByte);

        // myByte에 만약 byte 범위를 벗어나는 값을 할당하면?

        // myByte=1000;Thread [main] (Suspended (Type mismatch: cannot convert from int
        // to byte))

        // myByte = 1000; > 에러 발생

        System.out.println("---------------");
        System.out.println();

        // 2. 실수형 데이터타입

        System.out.println("2. 실수형 데이터타입");
        // double 데이터타입 변수 myDouble을 선언하고 12.345를 할당.

        double myDouble = 12.345;

        // 화면에 myDouble의 현재 값 출력

        System.out.println(myDouble);
        
        //myDouble에 5를 할당
        
        myDouble = 5;
        
        //화면에 myDouble의 현재 값 출력
        
        System.out.println(myDouble);
        
        //float 데이터타입의 공간에 값을 저장할 때에는
        //해당 실수가 float 타입인것을 컴퓨터에게 알려줘야 하므로
        //값뒤에 f를 붙여준다.
        
        //float 변수 myFloat 선언
        
        float myFloat;
        //myFloat에 float 데티어타입의 값 12.3할당
        
        myFloat = 12.3f;
        
        System.out.println(myFloat);
        
        System.out.println("---------------");
        
        //3. 문자형 데이터타입
        
        System.out.println("3. 문자형 데이터타입");
        
        //char 데이터타입의 변수 myCharacter 선언
        char myCharacter;
        //myCharacter에 'A' 할당
        myCharacter = 'A';
        //화면에 myCharacter의 현재 값 출력
        
        System.out.println(myCharacter);
        
        // char는 기본형 데이터타입의 공간이므로
        // 실제로는 해당 글자의 코드 값을 2진법으로 저장한다.
        // 따라서 아래의 코드도 가능하다.
        
        //myCharacter에 int값 97저장
        myCharacter = 97;
        System.out.println(myCharacter);
        
        //화면에 character 데이터타입의 값을 가진 'AB'를 출력하려고 한다면?
        
        myCharacter = 065;
        
        System.out.println("----------------");
        // System.out.println('AB'); > character 데이터타입의 값은 한번에 한개의 글자만
        // 제어할 수 있으므로 에러 발생
        
        // 4. 논리형 데이터타입
        
        System.out.println("4. 논리형 데이터타입");
        
        //boolean 데이터타입의 변수 myBoolean 선언
        boolean myBoolean;
        
        //myBoolean에 true를 저장
        myBoolean = true;
        // 화면에 myBoolean의 현재 값 출력
        System.out.println(myBoolean);
        // myBoolean에 false를 저장
        myBoolean = false;
        // 화면에 myBoolean의 현재 값 출력
        System.out.println(myBoolean);
        System.out.println("----------------");
        
        System.out.println();

    }

}
