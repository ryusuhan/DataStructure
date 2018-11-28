package org.sopt.SimpleLinkedList;

public class myLinkedListtest{

    public  static void main(String[] args){

        MySimpleLinkedList list = new MySimpleLinkedList();

        //구현 된 것에서 add 메소드를 사용하면
        //add(data)를 통해 addLast()가 호출되고, addLast()는
        //add(size, object)를 호출해서 처리하게된다.
        list.add(100);
        list.add(300);
        list.add(400);
        list.add(500);

        //toString 메소드를 통해 [] 모양안에 들어가서 출력되게 될 것이다.
        System.out.println(list);
        //[100, 300, 400, 500]가 출력된다.

        //1번 index에 200이라는 숫자를 밀어넣게 된다.
        list.add(1,200);
        //[100, 200, 300, 400, 500]로 들어가 있을 것!

        list.addFirst(50);
        System.out.println(list);
        //[50, 100, 200, 300, 400, 500]가 출력될 것이다.

        //get 메소드를 통해 4번 인덱스의 데이터를 가져오면
        //400이라는 데이터를 가져오게 될 것이다.
        System.out.println(list.get(4));

        //index로 요소를 삭제해준 경우
        list.remove(2);
        //50이라는 data자체로 데이터를 지워준 것!
        list.remove(new Integer(50));
        System.out.println(list);
        //[100, 300, 400, 500]가 출력될 것이다.


        //첫번째, 마지막 list의 요소를 삭제해준다,
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        //300,400이 출력될 것이다.

        //size 메소드를 통해서 현재 SimpleLinkedList의 size를 가져온다
        System.out.println("크기 " + list.size());
        //2가 출력될 것이다.

    }
}
