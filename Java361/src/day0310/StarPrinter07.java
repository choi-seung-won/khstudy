package day0310;

import java.util.*;

public class StarPrinter07 {

    
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("별 라인수 입력");
        System.out.print("> ");
    
        int userInput = scanner.nextInt();
        
        scanner.nextLine();
        
        //분할코딩 윗부분

       
        for (int i = 1 ; i <= userInput; i  ++  ) {
            
            String star = "";
            
            int starwidth = i;
            int blankwidth = userInput-i;
            
            
            
            
            // starwidth 5미만처리
            
            for (int j = 1 ; j <=  starwidth ; j ++ ) {
                
                star += "*";
                
            }
            
            // blankwidth 처리
            
            
            for ( int j = userInput ; j > i; j --) {
                
                star += " ";
                
            }
            
            System.out.println(star);
            
            
           
             
        }
        
        for(int i = 1; i <= userInput ; i ++) {
            String stars = "";
            
            int starWidth = userInput - i +1;
            
            
            for ( int j  = 1; j <= starWidth - 1 ;j ++) {
                
                stars += "*";

            }
            System.out.println(stars);
            
        }
    }
    
    
}
