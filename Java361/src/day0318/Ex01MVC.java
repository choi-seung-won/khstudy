package day0318;
// MVC 패턴

// 우리가 지금까지는
// 한가지 목적에 맞춰서 모든 것들을 우리가 한개의 클래스에 모두 만들었다.
// 하지만 우리가 이제부터는 그렇게 한가지 목적을 위해 한개의 클래스만 사용하는것이 아니라
// 여러 종류의 클래스를 사용하게 된다.
// 예를 들어서 게시판 프로그램의 경우에는,
// 회원 기능이라는 측면과 게시판 측면이라는 두가지 분야로 나뉘고
// 거기에 맞추어서 여러가지 클래스를 준비해주어야 한다.

// 만약 우리가 여러분야가 있는 프로그램을 하나의 클래스안에 모두 다 적을 경우,
// 한 분야의 유지보수를 하려면 그 전체 프로그램을 모두 다 뜯어봐야 한다.

// 또한 , 이렇게 통짜로 만들어진 프로그램은 코드의 재사용성이라는 측면에서는 매우 부족한 모습을 보인다.
// 만약 우리가 목적에 맞추어 클래스를 나누면 특정 분야의 클래스만 우리가 다른데서도 재사용 가능하다.

// 객체지향의 5 원칙
// SOLID
// S: Single Responsibility Principle. 단일 책임 원칙
// O: Open-Closed Principle. 개방-폐쇄 원칙
// L: Liskov Substitution Principle. 리스코프 치환 원칙
// I: Interface Segregation Principle. 인터페이스 분리 법칙.
// D: Dependency Inversion Principle. 의존성 역전 원칙.

// 아직 여러분들은 학생의 단계이기 때문에 O,L,I,D 4가지 원칙은 신경쓰지 않아도 된다.
// 하지만 우리가 반드시 신경을 써야하는것은 바로 단일 책임 원칙이다.
// 단일 책임 원칙이란, 하나의 클래스는 하나의 책임만 지고 있어야 한다 라는 의미이다.

// 예를 들어보자, 지금 우리의 homework.Board 는 데이터타입의 책임과 출력의 책임을 둘 다 맡고있다.
// homework.Ex06Board의 경우, 데이터 출력과, 데이터 제어 두가지 책임을 맡고있다.
// 만약 단일 책임 원칙이 제대로 지켜진다면,
// 게시판 이라는 목적을 위해, 데이터타입, 데이터제어, 데이터 출력을 각각 담당하는 3개의 클래스가 필요해진다.
// 단일 책임 원칙을 지키기 위한 프로그래밍 방법론 중에 바로
// MVC 패턴이라는것이 등장하게 된다.
// MVC 패턴이란, 한가지 목적을 위해 클래스를 모델,뷰어,컨트롤러 3가지로 나누어 개발하는 방법론이다.
// M모델: 데이터타입을 담당
// V뷰어: 화면 출력을 담당
// C컨트롤러: 데이터제어를 담당

// 그래서 우리가 여기서는 학생에 대한 MVC 패턴과 그리고 그것을 실행하는 방법을 알아보게 될 것이다.


import viewer.StudentViewer;
public class Ex01MVC {
    
    public static void main(String[] args) {
        StudentViewer viewer = new StudentViewer();
        viewer.showMenu();
    }

}
