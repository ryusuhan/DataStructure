package org.sopt;

import java.util.Vector;

/**
 * Vectorex 코드를 보면 생성 시에 Vector로 Vector 객체에 담을 수 있는
 * 객체형을 한정짓는다.
 * 다양한 종류의 객체를 담고 싶다면 Vector 클래스를 확장한 클래스를 생성하여 사용한다.
 */

public class Vectorex2 extends Vector {

    public Vectorex2(int i){
        super(i);
    }

    public static void main(String[] args){
        //객체를 만들어준다.
        Vectorex2 vec1 = new Vectorex2(2);
        //위애 선언해준대로 capacity가 2가 될 것이다.
        System.out.println("vec1의 용량은 " + vec1.capacity());
        //capacirtIncrement를 통해 증가치를 알 수 있다.
        System.out.println("증가치는 " +vec1.capacityIncrement);
        //elementCount를 통해 현재 vector내의 요소의 수를 알 수 있다.
        System.out.println("현재 요소의 수는 " +vec1.elementCount);

        //이같은 방식으로 요소들을 추가할 수 있다.
        vec1.addElement(new Integer(10));
        vec1.addElement(new Double(12.71));
        vec1.addElement(new String("안녕하세요"));

        System.out.println("3개의 요소 삽입 후 현재 요소의 수 : " + vec1.elementCount);

        vec1.addElement("네, 안녕하세요");
        vec1.addElement(14);
        vec1.addElement(73.221);

        if(vec1.contains("안녕하세요")){
            System.out.println("안녕하세요 문자열은 " + vec1.indexOf("안녕하세요") + "번째 인덱스에 있다.");
        }

        if(vec1.contains(14)){
            System.out.println("14라는 숫자는 " + vec1.indexOf(14) + "번째 인덱스에 있다!");
        }

        //인덱스의 값을 찾아 출력하는 방법이다!
        System.out.println("1번째 인덱스의 요소는 " + vec1.elementAt(0));


    }
}

