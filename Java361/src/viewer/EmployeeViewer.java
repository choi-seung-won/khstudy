package viewer;
//뷰어

//뷰어는 주로 화면에 출력을 담당하는 프로그램들이다.

import java.util.ArrayList;
import java.util.Scanner;

import controller.EmployeeController;
import model.EmployeeDTO;

import util.ScannerUtil;

public class EmployeeViewer {

    // 사원 부서에 관한 상수
    private final int DEP_CODE1 = 1;
    private final int DEP_CODE2 = 2;
    private final int DEP_CODE3 = 3;
    // 사원 직급에 관한 상수
    private final int RANK_CODE1 = 1;
    private final int RANK_CODE2 = 2;
    private final int RANK_CODE3 = 3;
    private final int RANK_CODE4 = 4;
    // 사원 부서 입력시 사용할 String 상수
    private final String DEP_INPUT_MSG = "1. 총무 2. 개발 3. 영업";
    // 사원 직급 입력시 사용할 String 상수
    private final String RANK_INPUT_MSG = "1. 부장 2. 차장 3. 대리 4. 사원";

    // 데이터베이스 역할을 하는 ArrayList 객체를
    // 간접적으로 접근하기 위해 EmployeeController 필드
    private EmployeeController controller;
    // 데이터 입력을 처리하기 위한 Scanner 필드
    private Scanner scanner;

    private static int nextId;

    // 전역변수 초기화 메소드

    public EmployeeViewer() {
        controller = new EmployeeController();
        scanner = new Scanner(System.in);
    }

    // 메뉴출력 메소드 -x
    public void showMenu() {

        while (true) {

            String message = "1. 사원 정보 입력 2. 사원 목록 출력 3. 종료";

            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("thanksforusing");
                break;
            }
        }

    }

    // 정보 입력 메소드
    public void insert() {

        // 사원 정보를 담을 EmployeeDTO객체

        EmployeeDTO e = new EmployeeDTO();

        scanner = new Scanner(System.in);

        nextId = 1;

        e.setId(nextId++);

        String message = "사원의 이름을 입력해주세요.";
        e.setName(ScannerUtil.nextLine(scanner, message));

        message = "사원의 부서를 입력해주세요.(" + DEP_INPUT_MSG + ")";
        e.setDepartment(ScannerUtil.nextInt(scanner, message, DEP_CODE1, DEP_CODE3));
        message = "사원의 직급을 입력해주세요. (" + RANK_INPUT_MSG + ")";
        e.setRankCode(ScannerUtil.nextInt(scanner, message, RANK_CODE1, RANK_CODE4));
        message = "사원의 연봉을 입력해주세요.";
        e.setSalary(ScannerUtil.nextInt(scanner, message));

        // 컨트롤러로 e를 보내서 컨트롤러 필드 리스트에 추기한다
        controller.insert(e);

    }

    // 목록 출력 메소드 -x
    private void printList() {
        ArrayList<EmployeeDTO> temp = controller.selectAll();
        if (temp.isEmpty()) {

            System.out.println("등록된 정보가 없습니다.");

        } else {
            for (EmployeeDTO e : temp) {
                System.out.printf("%d. %s\n", e.getId(), e.getName());
            }
            String message = "상세보기할 사원의 번호 또는 뒤로가기를원할시 0을입력";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && controller.selectOne(userChoice) == null) {

                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    // 개별 출력 메소드 -x

    // 사원 개별 정보를 출력하고
    // 수정 삭제 목록보기를 입력받을
    // printOne()

    private void printOne(int id) {

        EmployeeDTO e = controller.selectOne(id);
        System.out.printf("번호: %d 이름: %s\n", e.getId(), e.getName());
        System.out.printf("부서: %s 직급: %s\n", 
                convertDepCode(e.getDepartmentCode()), convertRankCode(e.getRankCode()));
        System.out.printf("연봉: %s원\n", e.getSalary());
        String message = "1. 수정 2. 삭제 3. 목록으로가기.";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printList();
        }

    }

    // 부서코드를 부서명으로 바꿔주는 convertDepCode

    private String convertDepCode(int depCode) {
        if (depCode == DEP_CODE1) {
            return "총무";
        } else if (depCode == DEP_CODE2) {
            return "개발";
        } else if (depCode == DEP_CODE3) {
            return "영업";
        }
        return null;
    }

    // 직급 코드를 직급명으로 바꿔주는
    // convertRankCode
    private String convertRankCode(int rankCode) {
        if (rankCode == RANK_CODE1) {
            return "부장";
        } else if (rankCode == RANK_CODE2) {
            return "차장";
        } else if (rankCode == RANK_CODE3) {
            return "대리";
        } else if (rankCode == RANK_CODE4) {
            return "사원";
        }

        return null;
    }

    // 일치대상 서치 메소드 - 통으로코딩함

    // 수정

    private void update(int id) {
        
        // 수정한 정보를 임시로 담아둘 temp 객체
        EmployeeDTO temp = new EmployeeDTO();
        // temp로부터 수정된 정볼르 입력받아서 컨트롤러로 보내질 origin 객체
        EmployeeDTO origin = controller.selectOne(id);
        String message;
        // 1. 부서 수정 여부.
        message = "사원의 새로운 부서를 입력해주세요.(0. 수정안함 " +DEP_INPUT_MSG+")";
        temp.setDepartment(ScannerUtil.nextInt(scanner, message, 0, DEP_CODE3));
        message = "사원의 새로운 직급을 입력해주세요. (0. 수정안함 " +RANK_INPUT_MSG+")";
        temp.setRankCode(ScannerUtil.nextInt(scanner, message, 0, RANK_CODE4));
        message = "사원의 새로운 연봉을 입력하시거나 원래 값을 남기실려면 0을 입력해주세요.";
        temp.setSalary(ScannerUtil.nextInt(scanner, message));

        // 4. 부서 정보가 수정되었는지 확인하여
        // 수정되었으면 origin에 반영
       if(temp.getDepartmentCode() != 0) {
           origin.setDepartmentCode(temp.getDepartmentCode());
       }
        // 5. 직급 정보가 수정되었는지 확인하여
        // 수정되었으면 origin에 반영
       if(temp.getRankCode() != 0) {
           origin.setRankCode(temp.getRankCode());
       }
        
        // 6. 연봉 정보가 수정되었는지 확인하여
        // 수정되었으면 origin에 반영
       if(temp.getSalary() != 0) {
           origin.setSalary(temp.getSalary());
       }
        
        // 컨트롤러로 origin 객체전송
       
       controller.update(origin);
        
        message = "정말로 수정하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            controller.update(origin);
        }
        printOne(id);

    }

    private void delete(int id) {
        String message = "해당 정보를 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            controller.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

    // 메인 메소드-x

}
