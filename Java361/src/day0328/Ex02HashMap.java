package day0328;

// Map
// 자바의 Collection 이라는 인터페이스는
// 세부적으로 List, Set, Map 이라는 인터페이스들이 상속한다.
// 그리고 해당 인터페이스들은 실제 메소드가 구현되어있는
// 클래스들을 상속한다.
// List와 Set은 모두 index를 사용하는 순서가 존재하는 모음이지만
// Map에 속하는 클래스들은 index가 따로 없는 순서가 존재하지 않는 모음이다.
// Map중에서 가장 흔하게 쓰이는 HashMap을 한번 알아보자
import java.util.HashMap;

public class Ex02HashMap {
    public static void main(String[] args) {
        // HashMap은 순서가 없는 대신, 추가된 객체마다 "약속어" 를 만들어서
        // 그 약속어를 통하여 객체를 추가하거나 불러올 때 사용하게 된다.
        // 약속어의 경우에는 String 객체를 쓰는 경우가 많지만
        // 필요하다면 다른 클래스를 적어주어도 된다.
        // 우리는 여기서
        // String이 약속어, 엘리먼트는 ElementaryStudent인 맵을 만들어볼 것이다.
        HashMap<String, ElementaryStudent> map = new HashMap<>();

        ElementaryStudent e1 = new ElementaryStudent();
        e1.id = 1;
        e1.name = "학생1";
        e1.korean = 11;
        e1.english = 12;
        e1.math = 13;

        ElementaryStudent e2 = new ElementaryStudent();
        e2.id = 2;
        e2.name = "학생2";
        e2.korean = 21;
        e2.english = 22;
        e2.math = 23;

        ElementaryStudent e3 = new ElementaryStudent();
        e3.id = 3;
        e3.name = "학생3";
        e3.korean = 31;
        e3.english = 32;
        e3.math = 33;

        ElementaryStudent e4 = new ElementaryStudent();
        e4.id = 4;
        e4.name = "학생4";
        e4.korean = 41;
        e4.english = 42;
        e4.math = 43;

        ElementaryStudent e5 = new ElementaryStudent();
        e5.id = 5;
        e5.name = "학생5";
        e5.korean = 51;
        e5.english = 52;
        e5.math = 53;

        // Map에 새로운 객체를 추가할 때에는?
        // put(key,val)의 형태로 추가한다. key = database의 key로생각

        map.put("학생1", e1);
        map.put("학생2", e2);
        map.put("학생3", e3);
        map.put("학생4", e4);
        map.put("학생5", e5);

        // Map에 저장된 객체를 불러올 때에는?
        // get(key)
        // 단 , 해당 하는 키 값을 가진 밸류가 없을 때에는
        // null이 리턴된다.
        map.get("학생1").printInfo();
        System.out.println(map.get("aaaaaaaaaaa"));

        // 만약 특정 밸류가 맵에 존재하는지 찾을 떄에는
        // containsValue()
        System.out.println(map.containsValue(e1));

        // 만약 특정 키가 맵에 존재하는지 찾을 때에는
        // containsKey()
        System.out.println(map.containsKey("aaaaaaaaaaa"));

        // 기존 어레이리스트와 다르게
        // 우리가 향상된 forEach문을 곧장 map에는 적용시킬 수 없다.
        // 왜냐하면, Map 추가된 객체를 불러올 때에는 반드시 키("" = String) 값이 필요하기 때문.
        // 대신 우리는 keySet() 이라는 메소드를 통해서
        // 추가된 키들을 set의 형태로 불러와서 그걸 사용하여
        // 객체를 하나하나 불러올 수 있다.
        for (String key : map.keySet()) {
            ElementaryStudent e = map.get(key);
            e.printInfo();
        }
        
        // 번외.
        // 만약 똑같은 키 값을 여러개 추가하면 어떻게 될까?
        ElementaryStudent e6 = new ElementaryStudent();
        e6.id = 6;
        e6.name = "학생6";
        e6.korean = 61;
        e6.english = 62;
        e6.math = 63;
        
        map.put("학생1", e6);
        
        map.get("학생1").printInfo();
        
    }
}