package day0308;
import java.util.*;
public class StarPrinter03 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("***별라인수 입력***");
        System.out.print(">");
        
        int userInput = scanner.nextInt();
        scanner.nextLine();
        

        String stars = "";
        
        int j2 = userInput ;
        for( int i = 0 ;i < userInput ; i ++ ) {
            
            // 공백의 갯수를 저장하는 int변수 int spaceWidth = userNumber - i;
            for(int j = 1 ; j < j2 ; j ++) {
                
                System.out.print(" ");
                // stars += " " ;
            }
            stars += "*";
            System.out.println(stars);
            j2 --;

            
            /*
             * int starWidth = i;
             * for(int j = 1; j<= starWidth; j++)
             * {
             * stars +="*";
             * }
             * 
             * 
             * */
            
        }

    }

}
