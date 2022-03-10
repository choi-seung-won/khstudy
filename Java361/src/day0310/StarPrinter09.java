package day0310;

import java.util.*;

public class StarPrinter09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("라인수 입력");
        System.out.print(" > ");

        int userInput = scanner.nextInt();

        for (int i = 1; i <= userInput; i++) {

            String star = "";
            int blankwidth;
            int starwidth;

            if (i < userInput) {

                blankwidth = userInput - i;

                starwidth = 2 * i - 1;
            } else {
                // else 기준 i

                int lowerI = 2 * userInput - i;

                starwidth = 2 * lowerI - 1;

                // blankwidth

                blankwidth = userInput - lowerI;

                // black j for구문

                // starwidth
                // star j for 구문
            }
            // star처리
            for (int j = 1; j <= starwidth; j++) {

                star += "*";

            }

            // blank처리
            for (int j = 1; j <= blankwidth; j++) {
                star += " ";
            }

            

            System.out.println(star);
        }
    }
}
