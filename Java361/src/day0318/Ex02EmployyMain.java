package day0318;
// 사원관리 프로그램을 작성하시오.

// 단, MVC 패턴을 적용시키세요
// 9시까지

import viewer.EmployeeViewer;

public class Ex02EmployyMain {

    public static void main(String[] args) {

        EmployeeViewer viewer = new EmployeeViewer();
        viewer.showMenu();
        
    }

}

// 딱 한개 메소드만 적기
