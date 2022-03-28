package day0328;

// 인터페이스 상속은 implements 라는 키워드를 통해 이루어진다.
// 단 , implements를 통하여 인터페이스를 상속 받았을 경우
// 그 인터페이스 안에 선언된 모든 메소드를 '반드시 오버라이드'(unimplements method 있을경우 에러) 해주어야 한다.
public class ElementaryStudent implements StudentInterface {

    public int korean;
    public int english;
    public int math;
    public int id;
    public String name;

    @Override
    public int calculateSum() {
        return korean + english + math;
    }

    @Override
    public double calculateAverage() {
        return calculateSum() / 3.0;
    }

    @Override
    public void printInfo() {
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof ElementaryStudent) {
            ElementaryStudent e = (ElementaryStudent)o;
            return id == e.id;
        }
        return false;
    }
    


}
