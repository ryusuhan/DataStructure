package org.sopt;

/**
 * Vector란 결국 객체의 참조값을 저장하는 가변길이의 배열이다.
 * 객체의 참조값을 저장하기 때문에 여러 객체들을 하나에 Vector에 저장할 수 있고
 * 용량을 초과하게 되면 동적으로 배열의 크기를 증가 시킨다
 */

import java.util.Vector;

/**
 * Vector 클래스는 객체에 대한 참조값을 저장하는 배열이므로 다양한 객체들이 하나의
 * Vector에 저장될 수도 있고 길이도 필요에 따라 증감할 수 있다는 것이 배열과는 다른 점이다.
 */
public class Vectorex {
    public static void main(String[] args){
        //Vector(int size, int incr)로 선언하면 size개의 데이터를 저장할 수 있는 길이의 객체를 생성한다.
        //저장 공간이 부족한 경우 incr개씩 증가하게 된다. size와 incr을 매개변수로 넣지 않으면
        //size=10, incr=10의 값이 기본값으로 설정된다.
        //Vector를 생성하기 위해 아래 처럼 선언했다.
        //Vector 객체에 String형을 담을 수 있도록 햇으며, 용량은 3, size가 용량을 초과했을 때
        //3씩 용량이 증가한다.
        Vector<String> strvec = new Vector<String>(3);
        Vector<Integer> intvec = new Vector<Integer>(3);

        //size()를 통해서 vector의 크기를 알 수 있다
        //현재 저장된 값이 없으므로 0이 출력될 것이다.
        System.out.println("Vector의 크기 : " + strvec.size());
        //capacity()를 이용해서 vector의 용량을 알 수 있다.
        //최초 3을 선언해주었기 때문에 3이 출력될 것이다.
        System.out.println("Vector의 용량 : " + strvec.capacity());

        //String형 vector에 요소를 추가하는 방법은 addElement()로 추가한다.
        strvec.addElement("안지영");
        strvec.addElement("아이유");
        strvec.addElement("넉살");
        strvec.addElement("루피");

        //int형 vector에 요소를 추가할 때는 add()로 추가할 수 있다.
        //1~7까지를 vector에 넣었다
        for(int i = 1; i <8; i++){
            intvec.add(i);
        }

        //용량이 3인 vector에 4개의 요소를 삽입했으니 최초 용량을 넘어섰기 때문에
        //용량이 동적으로 3 늘어나서 6이 된다. size는 4가 출력될 것!
        System.out.println("Vector의 크기 : " + strvec.size());
        System.out.println("Vector의 용량 : " + strvec.capacity());

        //용량이 3이었던 vector에 7개의 요소를 삽입했으니 최초 용량을 넘어서고
        //6으로 늘어난 용량까지 넘어섰으니 6이 다시 추가되어 용량이 12가 될 것이다.
        //size는 넣은대로 7로 늘어났다!
        System.out.println("Vector의 크기 : " + intvec.size());
        System.out.println("Vector의 용량 : " + intvec.capacity());

        //Vector의 몇 번째 index의 값을 보여주는 함수는 elementAt(idx)이다.
        System.out.println("intvec의 첫 번째 요소 : " + intvec.elementAt(0));
        System.out.println("strvec의 두 번째 요소 : " + strvec.elementAt(1));

        //Vector의 원소를 삭제하는 방법은 remove()를 사용하거나
        //Vector의 모든 원소를 삭제하는 방법은 removeAllElements()를 사용하면 된다.

        //원소 이름을 통해 지울 수도 있고
        strvec.removeElement("넉살");
        //remove를 통해서 index에 있는 것을 지울 수 있다.
        //4개의 원소 중 하나를 지웠기 때문에 마지막 인덱스 번호는 2가 된다.
        strvec.remove(2);

        //원소 두개가 빠졌기 때문에 size는 2가 출력될 것이다.
        System.out.println("Vector의 크기 : " + strvec.size());
        //늘어난 용량은 줄어들지 않고 6이 된다.
        System.out.println("Vector의 용량 : " + strvec.capacity());

        //모든 원소를 지운다.
        strvec.removeAllElements();

        //모든 원소를 다 지웠으니 size()는 0이될 것이다.
        System.out.println("Vector의 크기 : " + strvec.size());
        //하지만 이미 늘렸던 용량은 6으로 출력된다.
        System.out.println("Vector의 용량 : " + strvec.capacity());
    }
}
