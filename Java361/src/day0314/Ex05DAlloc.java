package day0314;

// 배열의 동적 할당(Dynamic Allocation)
// 배열의 가장 큰 단점은
// 우리가 맨 처음부터 크기를 특정지어야 한다는 것이다.
// 만약 우리가 지정된 크기 이상의 값을 넣을때도 문제가 있고,
// 반대로 우리가 어디 인덱스가 비어있는지를 찾는것또한 문제가 된다.
// 이런 모든 문제는 배열의 크기가 고정, 즉 "정적 할당(Static Allocation)" 되어있기 때문에
// 발생되는 문제이다.
import util.ArrayUtil;
// 이러한 문제를 해결하기 위해 우리는
// 배열의 크기를 자유자재로 변경 가능한 "동적할당" 이란 것을 배워보고
// 그리고 배열을 사용할 때 도움이 되는 여러가지 메소드를 같이 한번 만들어볼 것이다.

// 동적할당이란, 배열의 크기가 고정되어있지 않고
// 우리가 추가하면 배열이 늘어나고, 삭제하면 배열이 줄어드는 그러한 형태를
// 동적할당된 배열 이라고 한다.

public class Ex05DAlloc {
    public static void main(String[] args) {

        // 1. int[]
        int[] intArray = new int[4];
        intArray[0] = 40;
        intArray[1] = 20;
        intArray[2] = 30;
        intArray[3] = 40;
        // A. size(int[])
        System.out.println("1-A. size(intArray): " + ArrayUtil.size(intArray));
        // B. isEmpty()
        System.out.println("1-B. isEmpty(intArray): " + ArrayUtil.isEmpty(intArray));
        // C. get(int[] , int)
        System.out.println("1-C. get(intArray, 1): " + ArrayUtil.get(intArray, 1));
        // D. contains(int[] , int)
        System.out.println("1-D. contains(intArray,30): " + ArrayUtil.contains(intArray, 30));

        System.out.println("1-D. contains(intArray,5): " + ArrayUtil.contains(intArray, 5));

        // E. indexOf(int[],int)
        System.out.println("1-E. contains(intArray,40): " + ArrayUtil.indexOf(intArray, 40));

        System.out.println("1-E. contains(intArray,5): " + ArrayUtil.indexOf(intArray, 5));
        // E. lastindexOf(int[],int)
        System.out.println("1-F. contains(intArray,40): " + ArrayUtil.lastIndexOf(intArray, 40));

        System.out.println("1-F. contains(intArray,5): " + ArrayUtil.lastIndexOf(intArray, 5));

        // G. add(int[],int)
        System.out.println("1-G. add() 전 size(intArray): " + ArrayUtil.size(intArray));
        intArray = ArrayUtil.add(intArray, 80);
        System.out.println("1-G. add() 후 size(intArray): " + ArrayUtil.size(intArray));

        System.out.println("1-H. add() 전 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-H. add() 전 get(intArray, 2): " + ArrayUtil.get(intArray, 2));
        intArray = ArrayUtil.add(intArray, 2, 25);
        System.out.println("1-H. add() 후 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-H. add() 후 get(intArray, 2): " + ArrayUtil.get(intArray, 2));

        // I. set(int[] , int , int)
        System.out.println("1-I. set() 전 get(intArray, 2): " + ArrayUtil.get(intArray, 2));
        int temp = ArrayUtil.set(intArray, 2, 400);
        System.out.println("1-I. set() 후 get(intArray, 2): " + ArrayUtil.get(intArray, 2));
        System.out.println("1-I. set() 후 기존2번 인덱스에 저장되어있던 값:" + temp);

        // J. removeByIndex(int[], int)
        System.out.println("1-J. remove()전 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-J. remove()전 size(intArray,2): " + ArrayUtil.get(intArray, 2));
        System.out.println("1-J. remove()전 size(intArray,3): " + ArrayUtil.get(intArray, 3));
        intArray = ArrayUtil.removeByIndex(intArray, 2);
        System.out.println("1-J. remove()후 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-J. remove()후 size(intArray,2): " + ArrayUtil.get(intArray, 2));// 3번index에있던 30이 2번으로감
        System.out.println("1-J. remove()후 size(intArray,3): " + ArrayUtil.get(intArray, 3));

        // K. removeByElement(int[] , int)
        System.out.println("1-K. removeByElement() 전 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-K. removeByElement() 전 contains(intArray, 30): " + ArrayUtil.contains(intArray, 30));

        intArray = ArrayUtil.removeByElement(intArray, 30);
        System.out.println("1-K. removeByElement() 후 size(intArray): " + ArrayUtil.size(intArray));
        System.out.println("1-K. removeByElement() 후 contains(intArray, 30): " + ArrayUtil.contains(intArray, 30));


    }

}
