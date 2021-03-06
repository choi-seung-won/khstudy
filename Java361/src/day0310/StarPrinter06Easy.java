package day0310;
// blank 4-3-2-1
import java.util.*;
public class StarPrinter06Easy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("별 라인수 입력");
        System.out.print("> ");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        
        
        
        // i의 감소로 루프를 돌리므로 input - for(i)구문반복횟수
        
        for ( int i = userInput ; i >= 1 ; i--) {
            String stars = "";
            
            int spaceWidth = userInput -i;
            
            for(int j = 1; j <= spaceWidth ; j++) {
                stars += " ";
            }
            
            int starWidth = 2* i - 1;
            
            for(int j = 1; j <= starWidth ; j ++) {
                stars += "*";
            }
            
            System.out.println(stars);
        }
        

    }

}
