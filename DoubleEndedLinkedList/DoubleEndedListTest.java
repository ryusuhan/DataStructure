package org.sopt.DoubleEndedLinkedList;

public class DoubleEndedListTest {
    public static void main(String[] args){

        /**
         * test방식은 SimpleLinkedList와 같다.
         */

        MyDoubleEndedLinkedList list = new MyDoubleEndedLinkedList();

        //add()메소드를 통해서 list에 요소를 추가한다.
        //add()의 경우 마지막에 삽입되므로
        list.add(200);
        list.addFirst(100); //이러한 순서로 삽입시
        list.addLast(400); //100,200,400,500 순서로 삽입될 것
        list.add(500);
        System.out.println(list);

        //2번째 인덱스에 300이라는 값을 집어넣는다.
        list.add(2, 300);
        System.out.println(list);//100~500까지 순차적으로 출력될 것

        //2번 인덱스의 요소를 삭제한다.
        list.remove(2);
        //data를 통해서 list에서 해당 요소를 삭제한다.
        list.remove("400");
        //이러한 방법으로도 요소를 삭제할 수 있다.
        list.remove(new Integer(200));
        //200,300,400을 지웠으니 100,500만 남은 list가 출력될 것

        list.add(1, 200);
        list.add(2,300);
        list.add(3, 400);

        list.removeFirst();
        list.removeLast();
        //맨 처음과 마지막 요소를 삭제했으니 200,300,400이 출력될 것
        System.out.println(list);

        //현재 요소가 세개 삽입되어 있으니 3이 출력될 것이다.
        System.out.println("list의 크기 : " + list.size());
    }
}
