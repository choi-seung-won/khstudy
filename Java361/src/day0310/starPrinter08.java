package day0310;

import java.util.*;

public class starPrinter08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("라인입력");

        System.out.print(">");

        int userInput = scanner.nextInt();

        for (int i = 1; i <= userInput;) {

            String star = "";
            int starWidth = 0;
            int blankWidth = 0;
            // blank처리

            for (int j = userInput; j > i; j--) {

                star += " ";

            }
            for (int j = 1; j <= i; j++) {

                star += "*";
            }

            System.out.println(star);

            if (i == userInput) {
                for (int j = userInput - 1; j > 0; j--) {
                    star = "";
                    // blank
                    for (int k = j; k < userInput; k++) {
                        star += " ";
                    }
                    // stringstar
                    for (int k = j; k > 0; k--) {
                        star += "*";
                    }
                    System.out.println(star);
                }
            }
            i++;
        }

    }

}
