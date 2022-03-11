package day0310;

import java.util.*;

public class StarPrinter10 {public static void main(String[] args) {

    

    Scanner scanner = new Scanner(System.in);



    System.out.println("라인수 입력");

    System.out.print(" > ");



    int userInput = scanner.nextInt();

    

    int iMin = 1;

    int iMax = 2* userInput - 1;



    for(int i = iMin ;i <= iMax ; i ++) {

        

        String star = "";

        //가로의 폭

        int maxWidth = 2 *userInput - 1;

        

        if(i == iMin || i == iMax ) {

            // 맨 첫번째줄과 맨 마지막줄

            for(int j =1 ; j <= maxWidth; j ++) {

                star += "*";

            }

            // 공백의 갯수를 저장할 변수

            // 별의 갯수를 저장할 변수

            //starwidth = userInput*2 - 2*i;

        }else {

            int blankwidth = 0;

            int starwidth = 0;

            

            if(i < userInput ) {

                // 윗부분

                // 윗부분의 기준이 될 upperI

                int upperI = i - 1;

                

                // upperI번째 줄의 한쪽 별의 갯수

                starwidth = userInput - upperI ;

                

                // upperI번째 줄의 가운데 공백의 갯수

                //blankwidth = maxWidth - 2 * starwidth;

            }else {

                //아랫부분

                

                //아랫부분의 기준이 될 lowerI

                int lowerI = i - userInput + 1;

                //lowerI번쨰 줄의 한쪽 별의 갯수

                starwidth = lowerI;

                //lowerI번째 줄의 가운데 공백의갯수

                //blankwidth= maxWidth - 2 * starwidth;

            }

            // 가운데 공백의 갯수

            

            //blankwidth = i * 2;



            

        

            

        blankwidth = maxWidth - 2 * starwidth;



            // 왼쪽 별을 담당하는 j for문

            

            for (int j = 1 ; j <= starwidth ; j ++) {

                star += "*";

            }

            

            for ( int j = 1; j <= blankwidth ; j ++) {

                star += " ";

            }

            

            

            // 오른쪽 별을 담당하는 j for문

            

            for (int j = 1 ; j <= starwidth ;j++) {

                star +="*";

            }

        }

            

            

            System.out.println(star);

        }

    }
    }
