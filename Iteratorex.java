package org.sopt;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteratorex {
    /**
     * Iterator란 자동으로 Index를 관리해주기 때문에, 사용에 편리함이 있을 수는
     * 있으나 Iterator 파일을 열어보면 객체를 만들어서 사용하기 때문에
     * 속도가 느릴 수 밖에 없는 구조로 되어 있다.
     */
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        //Iterator를 쓰기 위해 자료구조를 하나 먼저 생성해준다

        for(Iterator<Integer> itr = list.iterator(); itr.hasNext();){
            list.get(itr.next());
        }
        //hasNext()는 읽어올 요소가 남아있는지를 확인하는 메소드이다. 있으면 true 없으면 false를 반환한다.
        //next()는 읽어올 요소가 남아있는지 확인하는 메소드이다. 있으면 true, 없으면 false를 반환한다.
    }
}
