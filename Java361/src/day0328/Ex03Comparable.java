package day0328;

import java.util.ArrayList;
import java.util.Collections;

import model.BoardDTO;

// 객체의 비교 그리고 정렬
public class Ex03Comparable {
    public static void main(String[] args) {
        
        BoardDTO b = new BoardDTO();
        b.setId(1);
        b.setTitle("제목1");
        b.setContent("내용1");
        
        BoardDTO b2 = new BoardDTO();
        b2.setId(2);
        b2.setTitle("제목2");
        b2.setContent("내용2");
        
        BoardDTO b3 = new BoardDTO();
        b3.setId(3);
        b3.setTitle("제목3");
        b3.setContent("내용3");
        
        BoardDTO b4 = new BoardDTO();
        b4.setId(4);
        b4.setTitle("제목4");
        b4.setContent("내용4");

        ArrayList<BoardDTO> list = new ArrayList<>();
        
        list.add(b2);
        list.add(b);
        list.add(b4);
        list.add(b3);
        
        // 우리가 따로 만든 클래스를 템플릿으로 하는 어레이리스트를 정렬하기 위해서는
        // 어떤것을 기준으로 하여 정렬을 할지 기준점을 설정해야한다.
        // 이 기준점을 설정하기 위해서는
        // 클래스에 Comparable<클래스이름> 이라는 인터페이스를 상속받아서
        // compareTo()라는 메소드를 오버라이드해야한다.
        Collections.sort(list);
        
        for(BoardDTO b1 : list) {
            System.out.println(b1.getTitle());
        }
    }
}
