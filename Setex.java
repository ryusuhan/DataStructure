package org.sopt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Setex {
    /**
     집합은 요소의 순서를 상관하지 않고 저장한 컬렉션을 말하며
     이를 위해 Set 인터페이스를 구현하고 있다.
     Set은  1. 요소가 중복될 수 있고, 2. 순서가 있을 수 있고, 3. 정렬될 수도 있다.

     이러한 Set 인터페이스를 구현하는 클래스에는 HashSet, LinkedHashSet, TreeSet이 있다.
     1. HashSet : 빠른 접근 속도, 중복 X, 순서 X
     2. LinkedHashSet : 중복 허용 X, 삽입 순서에 의해 반복
     3. TreeSet : 중복 허용 X, 정렬된 순서에 의해 반복 된다.
     위에서 중복 허용을 하지 않음은 이미 존재하는 요소를 다시 추가하더라도
     이 요소가 두개 존재하지는 않는 다는 것을 의미한다.
     */

    public static void main(String[] args){
        //HashSet 예제
        Set<String> hashset = new HashSet<String>();

        hashset.add("1");//add함수로 Set에 원소들을 추가한다.
        hashset.add("2");
        hashset.add("3");
        hashset.add("4");
        hashset.add("1");// 1을 중복으로 넣어도 결과에는 1,2,3,4만 나오게 된다.

        for(Iterator i = hashset.iterator(); i.hasNext();){
            System.out.println(i.next());
        }

        //contains 함수를 쓰면 Set에 추가된 요소가 있다면 true를 반환한다.
        System.out.println(hashset.contains("1"));//1은 있으니 true
        System.out.println(hashset.contains("5"));//5는 없으니 false

        //Set에 요소를 하나도 포함하지 않는다면 true, 요소가 있다면 false
        System.out.println(hashset.isEmpty());// 요소가 있으니 false를 반환한다.

        //Clear명령을 이용해 Set의 모든 요소를 제거한다.
        hashset.clear();

        System.out.println(hashset.isEmpty());//요소가 다 제거 되었으므로 true

        hashset.add("a");
        hashset.add("b");
        hashset.add("c");
        hashset.add("d");
        hashset.add("e");

        //원하는 요소만을 삭제해야하는 경우에 remove(object)함수로 지울 수 있다.
        hashset.remove("c");

        for(Iterator i = hashset.iterator(); i.hasNext();){
            System.out.println(i.next());
        } //c를 지웠기 때문에 abde만 출력된다!

        //Set의 크기를 알기 위해서는 size()명령어를 사용한다.
        System.out.println(hashset.size()); //현재 abde가 set의 요소로 들어가 있으므로
        //4가 출력될 것이다.

        //Set에 포함된 모든 요소를 배열로 반환하려면 toArray()함수로 할 수 있다!
        Object[] ObjArr = hashset.toArray(); //그냥 String형으로는 받을 수 없다.

        for(int i = 0; i < ObjArr.length; i++) {
            System.out.println(ObjArr[i]);
        } //abde가 출력될 것을 알 수 있다.

        //c를 뺐다가 다시 넣어보았다.
        hashset.add("c");

        for(Iterator i = hashset.iterator(); i.hasNext();){
            System.out.println(i.next());
        } //정렬되어 저장되기 때문에 abcde로 출력이 될 것이다.



        //TreeSet도 위와 동일한 방법으로 사용할 수 있다.
        Set<String> treeset = new TreeSet<String>();

        treeset.add("A");
        treeset.add("C");
        treeset.add("E");
        treeset.add("D");
        treeset.add("B");

        for(Iterator i = treeset.iterator(); i.hasNext();){
            System.out.println(i.next());
        }//또한 정렬되어 저장되기 때문에 ABCDE의 순서로 나올 것을 예상할 수 있다.
    }
}
