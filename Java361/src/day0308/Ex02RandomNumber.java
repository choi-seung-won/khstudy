package day0308;

// 랜덤 게임
// 이 프로그램은
// 플레이, 최고기록 보기, 종료의 기능으로 나누어져 있다.

// 만약 사용자가 플레이를 누르면
// 1부터 100까지의 난수를 컴퓨터가 만들어내고
// 사용자는 그 숫자를 맞추는것이 목표가 된다.
// 만약 사용자가 입력한 숫자가 컴퓨터의 숫자보다 작으면
// 화면에 "UP" 이라고 뜨고
// 반대의 상황에서는 "DOWN" 이라고 뜬다.
//사용자가 한번 입력할 때 마다 사용자의 점수는 1점씩 오르는데
// 이 게임에서는 더 낮은 점수를 받는것이 목표가 된다.
// 만약 사용자가 컴퓨터의 숫자를 맞추면 축하메세지와 함께
// 사용자의 이번 기록을 출력한다.
// 또한 사용자가 새로운 최고기록이면 사용자에게
// 새로운 최고 기록이 되었다는것을 알려주되
// 맞출시 메인메뉴로 return

// 최고기록 보기의 경우
// 현재 최고기록 점수를 보여주되
// 만약 플레이 기록이 존재하지 않을경우
// "아직 플레이 기록이 존재하지 않습니다" 라는 메세지만 화면에 출력이 된다.

// 쉬는시간 포함 4-50

import java.util.*;

public class Ex02RandomNumber {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int selection_check = 0;

        int inputvalue_user = 0;

        int currentUserScore = 0;

        int best_score = 0;
        
        int randomvalue_cpu = 0;

        boolean game_clear = false;

        while (!(selection_check == 3)) {

            System.out.println("랜덤 게임.");
            System.out.println("1. 플레이, 2. 최고기록 보기, 3. 종료");
            System.out.print(">");

            selection_check = scanner.nextInt();
            // scanner.nextLine();

            if (selection_check > 3) {
                System.out.println("잘못된값입니다");
            } else if (selection_check == 1) {

                // 컴퓨터의 숫자 결정
                randomvalue_cpu = random.nextInt(100) + 1;

                while (game_clear == false) {
                    // 사용자로부터 숫자를 입력받음
                    System.out.println("게임 플레이");
                    System.out.println("1부터 100사이의 임의의 정수를 입력하시오");
                    System.out.print(">");

                    inputvalue_user = scanner.nextInt();

                    scanner.nextLine();

                    if (inputvalue_user > 100 || inputvalue_user <= 0) {

                        System.out.println("잘못된 값입니다.");

                    } else {

                        // 사용자의숫자가 크면 down,크면up을출력하고 현재점수를 1증가
                        // 사용자가 입력한숫자가 컴퓨터의 숫자와 일치할때까지 반복

                        currentUserScore++;

                        if (randomvalue_cpu > inputvalue_user) {
                            System.out.println("UP");
                        } else if (randomvalue_cpu < inputvalue_user) {
                            System.out.println("DOWN");
                        } else {
                            System.out.println("grats");

                            game_clear = true;

                            System.out.printf("your score is : [%d] \n", currentUserScore);

                            // 사용자가 입력한 숫자가 컴퓨터의 숫자와 일치한다면
                            // 현재점수와 최고점수를 비교, 최고점수>현재점수일시
                            // 현재점수의 현재 값이 새로운 최고 점수가 된다
                            if (best_score == 0 || currentUserScore < best_score) {

                                System.out.println("you are new champion \n");
                                best_score = currentUserScore;
                            }
                            System.out.printf("current best score is : [%d] \n", best_score);
                        }
                    }
                }
            } else if (selection_check == 2) {

                if (best_score == 0) {
                    System.out.println("아직 플레이 기록이 존재하지 않습니다.");
                } else {
                    System.out.printf("best score is : [%d] \n", best_score);
                }

            } else {
                System.out.println("게임종료.");
            }

        }

    }

}
