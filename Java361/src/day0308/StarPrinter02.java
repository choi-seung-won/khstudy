package day0308;

import java.util.*;

public class StarPrinter02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("****");
        System.out.println("역순 별찍기");
        System.out.println("****");

        System.out.println("출력할 줄 수 입력");
        System.out.print(">");
        
        int UserNum = scanner.nextInt();
        int UserNum2 = UserNum;
        
        // String stars = "";
        
        for (int i = 0; i < UserNum ; i++) {
            
        // j for문이 반복하면서
        // String변수 stars의 현재 내용에
        // *을 이어붙여서 다시 stars에 저장해라
        //    stars +="*";
        //sysout stars
            
            for ( int j = UserNum2; j > 0 ; j--) {
                
                System.out.print("*");

            }
            UserNum2 --;
            System.out.println();

        }

        scanner.close();
    }

}
