package org.sopt;

import java.util.*;

public class Containerex {
    static Collection fill(Collection<String> collection){
        collection.add("dog");
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        return collection;
    }
    //Collection이란 하나 이상의 규칙이 적용되는 개별적 요소들을 모아둔 것으로
    //List는 순차적으로 요소들을 저장하고, Set은 중복을 허용하지 않고,
    //Queue는 Queunig Discipline에 의해 요소들을 산출한다.

    static Map fill(Map<String, String> map){
        map.put("rat","Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Spike");
        map.put("dog", "lamblamb");
        return map;
    }
    //Map은 key와 value가 하나의 쌍으로 구성되는 객체들을 모아놓은 것으로,
    //key를 사용하여 값을 검색할 수 있다.
    //Map을 연관 배열(associative array)라고도 한다.

    public static void main(String[] args){
        System.out.println("ArrayList : \t" + fill(new ArrayList<String>())); //중복 요소가 존재하고, 순차적으로 요소들이 저장된다.
        System.out.println("LinkedLsit : \t" + fill(new LinkedList<String>())); //중복 요소가 존재하고, 순차적으로 요소들이 저장된다.
        System.out.println("HashSet : \t" + fill(new HashSet<String>())); //중복이 허용되지 않으며, 순차적으로 저장되지는 않는다.
        System.out.println("TreeSet : \t" +fill(new TreeSet<String>())); //중복이 허용되지 않으며 오름차순으로 정렬된다.
        System.out.println("LinkedHashSet : " + fill(new LinkedHashSet<String>())); //중복이 허용되지 않으며, 입력순서대로 데이터가 순차적으로 저장된다.
        System.out.println("HashMap : \t" + fill(new HashMap<>())); //key와 value로 이루어져 있고, 순차적으로 저장되지 않는다.
        System.out.println("TreeMap : \t" + fill(new TreeMap<>())); //key와 value로 이루어져 있으며, key로 오름차순 정렬되어 있다.
        System.out.println("LinkedHashMap :" + fill(new LinkedHashMap<>())); //key와 value로 이루어져 있으며, 추가된 순서를 보장한다.

        //이러한 컨테이너를 우리가 사용하는 이유는 크기를 지정할 필요가 없다는 것이다.
        //이들 컨테이너는, 요소가 추가될 때마다 크기를 동적으로 추가시킨다는 것이다.
    }
}
