package org.sopt;

import java.util.ArrayList;
import java.util.List;

//List 클래스는 배열의 한계 때문에 만들어진 자료형이다.
//배열을 사용하기 위해서는 크기를 정해야 하지만
//프로그래밍 중 크기를 알 수 없는 경우가 더 많기 때문에 곤란한 경우가 자주 발생한다.
//이 문제를 해결하기 위해 List는 메모리가 허용하는 한 계속해서 추가 할 수 있도록 만든
//자료형 클래스이다.
public class listex {
    public static void main(String[] args){
        List listA = new ArrayList();
        //List에 값을 추가하는 add() 함수
        listA.add("류수한");
        listA.add("지효근");
        listA.add(new String("이진호"));
        listA.add("강세린");
        listA.add("조재현");
        listA.add("이민형");

        //이렇게 인덱스를 지정해주면 해당 위치 앞에 값이 추가된다.
        listA.add(1, "1번째 요소 수정");
        listA.add(4,"돌맹이");

        //List의 값을 조회하는 get(index)함수!
        String element0 = listA.get(0).toString();
        String element1 = listA.get(1).toString();
        String element2 = listA.get(2).toString();

        //List의 값을 삭제하는 remove함수
        //remove(Object element), remove(int index) 두가지 방법이 있다.
        //인덱스를 이용하는 방법과, 동일한 오브젝트를 인수로 넘기면 검색하여 삭제하는 방법!
        //Object를 이용해서 삭제시 삭제 결과가 성공인지 실패인지만 알려주고,
        //index를 이용해서 삭제시 어떤 데이터를 삭제했는지 리턴값으로 알려준다.

        System.out.println(listA.remove(0));
        System.out.println(listA.remove("이진호"));

        //List에 값이 들어있는지를 확인하는 방법 contains함수!

        System.out.println(listA.contains("이진호"));
        System.out.println(listA.contains("조재현"));
        System.out.println(listA.contains("돌덩이"));

        //해당 위치 앞에 값을 집어넣고 싶을 때는 indexOf함수를 활용!
        //add에서 값을 추가할 때 add함수의 첫번째 인수로 인덱스를 넘기게 되면
        //해당 위치 앞에 값이 추가 된다고 했다.
        //위치를 알고 있으면 index를 지정해주면 되지만 알 수 없을 때는
        //indexOf()함수를 이용해서 위치 값을 찾은 뒤 add()함수를 이용하여 추가한다.

        int index = listA.indexOf("이민형");
        listA.add(index, "민형이 앞에 정민이");

        //index를 알면 아래와 같이 list.get으로 가져올 수 있다.
        System.out.println(listA.get(4));
        System.out.println(listA.get(6));
    }
}
