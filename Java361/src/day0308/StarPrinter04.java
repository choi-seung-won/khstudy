package day0308;
import java.util.*;

public class StarPrinter04 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별 라인수 입력");
        System.out.print("> ");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        
        
        int userInput2 = userInput;
        
        
        for (int i = 1 ; i <= userInput ; i ++) {
            String star = "";

            int blank = i -1 ;
            
            for ( int j = 1; j<=blank ; j++) {
                star +=" ";
            }
            int starWidth = userInput - blank;

            for (int j=1 ; j <=starWidth ;j ++) {
                // j loop로 늘어나는것 = star
                
                star += "*";

            }
            
            
            // int i loop로 늘어나는것 = blank
            // j loop후 star출력
           // System.out.print(blank);
            System.out.println(star);
            // 필요하지않음 jloopVar --;
            
        
        }
        
        
        
        
    }

}
