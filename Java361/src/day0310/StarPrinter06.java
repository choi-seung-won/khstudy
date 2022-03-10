package day0310;


import java.util.*;

public class StarPrinter06 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별라인수 입력");
        System.out.print(">");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        int i = 0;

        
        for(i = 1; i <= userInput; i ++)
        {
            int userblank = i*2-1;
            
            
            // 별의 갯수
            // 첫번째 줄의 별의 갯수
            // 9 = (-2 *1)+1
            // 9 = -2 + x
            // 9 + 2 = -2 +2 +x
            // 11 = x
            // 11 = 2 * 5 + a
            // 11 = 10 + a
            // a = 1
            
            // 11 = (-2*1) +x
            // 11 = x -2
            // 13 = x

            String stars = "";
            
            // int starWidth = -2* i + 2 * userNumber + 1;
            int starWidth = userInput*2 - userblank;
            int blankWidth = i - 1;


            
            for(int j = 1 ; j <= blankWidth; j ++) {
            
            stars += " ";

            }
            
            
            for(int j = 1 ; j <= starWidth ; j ++ ) {
                
               stars += "*"; 
                
                
            }
            System.out.println(stars);
            
            
            
        }
        
        
    }

}
