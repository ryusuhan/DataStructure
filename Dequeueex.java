package org.sopt;

/**
 * 일반적인 큐의 경우 데이터 삽입과 삭제가 한 쪽 방향에서만 발생하지만
 * 덱은 리스트의 양쪽 끝 모두에서 데이터를 삽입하고, 삭제할 수 있도록 만들어진
 * 특별한 형태의 자료구조이다.
 */

/**
 * 양쪽 방향 모두에서 삽입과 삭제가 발생할 수 있으므로 큐나 스택으로 모두 활용할 수 있다.
 * 만약 한쪽 방향에서 삽입과 삭제를 모두 처리하면 스택으로 동작하는 것이고,
 * 한쪽 방향에서는 삽입만 발생하고 반대에서는 삭제만 발생하도록 하면 큐처럼 작동하게 된다.
 */

//Deque를 사용하려면 java.util.Deque를 import 해야한다.
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Dequeueex {

    /**
     * 즉, Double-Ended Queue의 줄임말
     * 큐의 양쪽끝에서 삽입과 삭제가 모두 발생할 수 있는 큐를 말한다.
     * 결론적으로, Queue + Stack의 기능을 가졌다고 말할 수 있다!
     */

    public static void main(String[] args) {
        //ArrayDeque와 LinkedList가 주로 사용된다.
        Deque<Integer> test = new ArrayDeque<Integer>();
        Deque<String> deque = new LinkedList<>();

        //Deque에 요소를 삽입할 때는 add를 사용하면 된다!!
        test.add(2); //Deque의 마지막에 삽입한다.
        test.addFirst(1); //Deque의 front에 요소를 삽입한다.
        test.addLast(3); //Deque의 rear에 요소를 삽입!(마지막에)
        deque.add("맨뒤에");
        deque.addFirst("맨앞에");
        deque.addLast("맨뒤보다 더 뒤에");

        Iterator<Integer> i = test.iterator();
        Iterator<String> s = deque.iterator();

        //Iterator를 만들어주고 hasnext로 확인해주면서 반복해주고
        //next를 통해 다음 요소를 출력해주었다.
        while(i.hasNext()){
            System.out.println(i.next());
        } //처음에 2를 맨뒤에 넣고, 1을 맨앞에, 3을 또 맨뒤에 넣어주었으니
          //123 순서대로 출력될 것이다.

        while(s.hasNext()){
            System.out.println(s.next());
        } //들어가있는 요소의 순서대로 출력될 것이다.

        //offer도 add와 같은 방식으로 사용할 수 있고, offer도 요소를 추가하는데 사용된다.
        test.offer(4);
        test.offerFirst(0);
        test.offerLast(5);

        Iterator<Integer> i2 = test.iterator();
        while(i2.hasNext()){
            System.out.println(i2.next());
        }//0~5까지 차례대로 출력될 것을 알 수 있다.

        //push는 Deque의 맨 앞부분(Front)에 요소를 삽gk
        deque.push("맨앞보다 더 앞에!");

        Iterator<String> s2 = deque.iterator();
        while(s2.hasNext()){
            System.out.println(s2.next());
        }//push를 통해 맨 앞부분에 넣은 것까지 합쳐서 출력될 것!

        //poll명령어를 통해서 Deque의 요소들을 제거할 수 있다.
        test.poll(); //그냥 poll을 쓰면 제일 앞에 있는 요소를 제거한다.
                    //Queue에서 Element를 제거하는 것으로 보면 될 것
        test.pollFirst();//Deque의 Front element를 제거한다.
        test.pollLast();//Deque의 rear데이터를 삭제한다.

        Iterator<Integer> i3 = test.iterator();
        while(i3.hasNext()){
            System.out.println(i3.next());
        }//Front의 요소 두개를 빼내고 Last의 요소 하나를 제거했으니
        //0,1,5가 제거된 2 3 4가 출력될 것!

        //pop을 통해서도 Front의 요소를 제거할 수 있다.
        //stack에서 요소를 제거하는 방식이라고 생각하면 된다.
        deque.pop();

        Iterator<String> s3 = deque.iterator();
        while(s3.hasNext()){
            System.out.println(s3.next());
        }

        /**
         * Queue는 FIFO(선입선출)구조이므로 제거해야 할 요소가 가장 Front에 들어온다.
         * 즉, 가장 앞에 있는 element!
         * Stack은 LIFO(후입선출)구조이므로 제거해야할 Element가 제일 rear에 들어온 것이다.
         * push를 통해 맨 마지막에 들어온 것!, 즉 가장 앞에 있는 element
         */

        //peek을 통해 값을 제거하지 않고 확인만 하는 것이 가능하다.
        System.out.println(test.peek()); //peek만 쓰면 Deque의 가장 앞에 잇는 요소를 반환한다.
        System.out.println(deque.peek());//front 데이터 출력
        System.out.println(test.peekFirst());//peekFirst를 통해서도 가장 앞에 있는 요소를 반환
        System.out.println(deque.peekFirst());//front 데이터 출력
        System.out.println(test.peekLast());//peekLast를 통해서 가장 뒤에 있는 요소를 반환한다.
        System.out.println(test.peekLast());//rear 데이터 출력

        //get을 통해서도 값을 반환할 수 있다.
        System.out.println(test.getFirst());
        System.out.println(test.getLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        Iterator<Integer> i4 = test.iterator();
        while(i4.hasNext()){
            System.out.println(i4.next());
        }

        Iterator<String> s4 = deque.iterator();
        while(s4.hasNext()){
            System.out.println(s4.next());
        }
        //이것으로 확인했을 때 get으로도 element가 삭제되지 않고
        //조회하는 식으로 반환한다는 것을 알 수 있다.

    }
}
