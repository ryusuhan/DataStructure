package org.sopt;

import java.util.LinkedList;
import java.util.Queue;

public class Queueex {
    /**
     * Queue는 FIFO(First In First Out)의 용도로 사용하는 자료구조!
     * Queue(큐) 클래스 인스턴스를 생성하기 위해서는 아래와 같이
     * LinkedList() 생성자를 호출해주면 된다.
     */

    public static void main(String[] args) {
        Queue exque = new LinkedList();

        String str1 = "1. 사과";
        String str2 = "2. 딸기";
        String str3 = "3. 포도";
        String str4 = "4. 배";

        //queue에 객체를 넣으려면 offer()함수를 통해서 넣는다.
        exque.offer(str1); //이런 식으로 이미 선언된 String 변수로도 되고
        exque.offer(str2);
        exque.offer(str3);
        exque.offer(str4);
        exque.offer("5. 수박"); // 직접 집어넣어도 된다.

        //peek()함수를 사용할 경우
        //큐의 맨 아래에 있는 객체를 반환한다. 이 경우 객체를 큐에서 제거하지는 않는다.
        while(exque.peek() != null){
            String queval = (String)exque.poll();
            System.out.println("que값은 " + queval);
        }
        //poll() 함수는 큐에서 데이터를 꺼내온다. 만일 Queue가 비어있다면 null을 반환!
        //poll()은 큐에서 데이터를 아예 빼내는 것이기 때문에 현재 queue는 비어있다.

        exque.offer(str1); //다시 queue를 채워본다
        exque.offer(str2);
        exque.offer(str3);
        exque.offer(str4);
        exque.offer("5. 수박");

        //삭제 시에는 remove() 함수를 사용하면 된다.
        exque.remove("5. 수박"); //원소의 내용이 5. 수박인 것을 삭제했다.
        exque.remove(exque.peek());//가장 아래의 원소를 삭제했다. 1. 사과가 사라졌을

        while(exque.peek() != null){
            String queval = (String)exque.poll();
            System.out.println("que값은 " + queval);
        } // 사과와 수박이 제외된 결과가 출력될 것을 예상할 수 있다. 다시 queue가 비었다.

        exque.offer(str1);//다시 원소를 채워보자
        exque.offer(str2);
        exque.offer(str3);
        exque.offer(str4);
        exque.offer("5. 수박");

        //clear()함수를 통해 queue안의 원소를 모두 비울 수 있다.
        exque.clear();

        System.out.println(exque.poll());//이렇게 찍으면 null이 출력될 것이다.

    }



}
