package homework;
// 숙제 2.
// 지금 현재 util.ArrayUtil에는 int[]을 기준으로한 동적할당 메소드만 존재한다.
// String[]을 기준으로 한 동적할당 메소드(A부터 K까지) 구현하시오
// 단, remove의경우 이름을 통일시켜준다.

import java.util.*;
import util.ArrayUtil;
public class Ex04ArrayUtil {

    public static void main(String[] args) {
        //String 배열 기준의 ArrayUtil 메서드를 실험해보는 클래스
        String[] arr = new String[3];
        arr[0] = "abc";
        arr[1] = "bcd";
        arr[2] = "cde";
        
        System.out.println("2. String[]");
        System.out.println("A. size()");
        System.out.println("2-A: " + ArrayUtil.size(arr));
        System.out.println("------------------------\n");
        
        System.out.println("B. isEmpty()");
        System.out.println("2-B: " + ArrayUtil.isEmpty(arr));
        System.out.println("------------------------\n");
        
        System.out.println("C. get()");
        System.out.println("get(arr,0): " + ArrayUtil.get(arr,0));
        System.out.println("------------------------\n");
        
        System.out.println("D. contains()");
        System.out.println("contains(\"abc\"): " + ArrayUtil.contains(arr,"abc"));
        System.out.println("contains(\"aaa\"): " + ArrayUtil.contains(arr,"aaa"));
        System.out.println("contains(new String(\"abc\")): " + ArrayUtil.contains(arr,new String("abc")));// new = 새로운주소값 생성.
        System.out.println("------------------------\n");
        

        System.out.println("E. indexOf()");
        System.out.println("indexof(\"abc\"): " + ArrayUtil.indexOf(arr,"abc"));
        System.out.println("indexof(\"aaa\"): " + ArrayUtil.indexOf(arr,"aaa"));
        System.out.println("indexof(new String(\"abc\"): " + ArrayUtil.indexOf(arr,new String ("abc")));
        System.out.println("------------------------\n");
        
        
        System.out.println("F. lastIndexOf()");
        System.out.println("lastIndexof(\"abc\"): " + ArrayUtil.lastIndexOf(arr,"abc"));
        System.out.println("lastIndexof(\"aaa\"): " + ArrayUtil.lastIndexOf(arr,"aaa"));
        System.out.println("lastIndexof(new String(\"abc\"): " + ArrayUtil.lastIndexOf(arr,new String ("abc")));
        System.out.println("------------------------\n");
        
        
        System.out.println("G. add()");
        System.out.println("add() 전 length: " + ArrayUtil.size(arr));
        System.out.println("add() 전 contains(def): " + ArrayUtil.contains(arr, "def"));
        
        arr = ArrayUtil.add(arr, "def");
        
        System.out.println("add() 후 length: " + ArrayUtil.size(arr));
        System.out.println("add() 후 contains(def): " + ArrayUtil.contains(arr, "def"));
        
        System.out.println("------------------------\n");
        
        System.out.println("H. add()");
        System.out.println("add() 전 length: " + ArrayUtil.size(arr));
        System.out.println("add() 전 indexOf(def): " + ArrayUtil.indexOf(arr,"def"));
        
        arr = ArrayUtil.add(arr, 0,"def");
        System.out.println("add() 후 length: " + ArrayUtil.size(arr));
        System.out.println("add() 후 indexOf(def): " + ArrayUtil.indexOf(arr,"def"));
        
        System.out.println("------------------------\n");
        
        System.out.println("I. set()");
        System.out.println("set() 전 get(2): " + ArrayUtil.get(arr, 2));
        
        String temp = ArrayUtil.set(arr, 2, "zzz");
        
        System.out.println("set() 후 get(2): " + ArrayUtil.get(arr, 2));
        System.out.println("set() 전 원래 2번 인덱스의 값: " +temp);
        System.out.println("------------------------\n");
        
        System.out.println("J. remove()");
        System.out.println("remove() 전 size(): " + ArrayUtil.size(arr));
        System.out.println("remove() 전 get(0): " + ArrayUtil.get(arr, 0));
        
        arr = ArrayUtil.remove(arr, 0);

        System.out.println("remove() 후 size(): " + ArrayUtil.size(arr));
        System.out.println("remove() 후 get(0): " + ArrayUtil.get(arr, 0));
        
        System.out.println("K. remove()");
        
        System.out.println("remove(zzz) 전 contains(zzz): " + ArrayUtil.contains(arr, "zzz"));
        System.out.println("remove(ttt) 전 size(): " + ArrayUtil.size(arr));
        
        arr = ArrayUtil.remove(arr, "zzz");
        arr = ArrayUtil.remove(arr, "ttt");
        System.out.println("remove(zzz) 후 contains(zzz): " + ArrayUtil.contains(arr, "zzz"));
        System.out.println("remove(ttt) 후 size(): " + ArrayUtil.size(arr));

        
        
    }
}
