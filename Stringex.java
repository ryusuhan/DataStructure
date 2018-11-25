package org.sopt;

/**
 * JAVA를 쓰다보면 String을 더할 때 그냥 +를 이용해서 더하곤 한다.
 * 하지만 JAVA 개발자라면 고민을 더 해보고 Class를 선택해서 사용할 필요가 있다.
 * String과 StringBuilder, StringBuffer를 어떤 경우에 사용하는지를 보도록 하자
 */

/**
 * Serializable, CharSequence, Comparable 인터페이스가 상속되어 있고
 * public final class로 되어 있다. 이를 해석해보면
 * serialize가 가능하며, 비교가능한 값이라는 것을 알 수 있다.
 * 그리고 final class이기 때문에 String class를 상속 받을 수는 없다.
 */

/**
 * String 타입을 알아보다 보면 String을 +연산으로 직접 더하는 것보다는
 * StringBuffer나 StringBuilder를 사용하는 것이 좋다는 말이 있다.
 * 이 이유에 대해서 알아보도록 하자!
 */

public class Stringex {
    public static void main(String[] args) {

        String strValue1 = "TEST 1";
        String strValue2 = "TEST 2";

        System.out.println("strValue1의 주소값 : " + strValue1.hashCode());
        System.out.println("strValue2의 주소값 : " + strValue2.hashCode());

        strValue1 = strValue1 + strValue2;
        System.out.println("strValue1의 주소값 : " + strValue1.hashCode());

        /**
         * String은 새로운 값을 할당할 때마다 새로 생성되기 때문에
         * 생성된 클래스의 주소값이 다르다.
         */

        StringBuffer sb = new StringBuffer();

        sb.append("TEST 1");

        System.out.println("sb의 주소값 : " + sb.hashCode());

        sb.append("TEST 2");

        System.out.println("sb의 주소값 : " + sb.hashCode());

        /**
         * 하지만 StringBuffer는 값을 memory에 append하는 방식으로
         * 클래스를 직접 생성하지 않는다.
         * 논리적으로 보면 클래스가 생성될 때 method들과 variable도 같이 생성 되는데
         * StringBuffer는 이러한 시간이 필요하지 않다는 것이다.
         */

        /**
         * 또한 위의 예제 코드는 한 번만 생성되었지만 수십번 String이 더해지는 경우는
         * 각 String의 주소값이 stack에 쌓이고 클래스들은 Garbage Collector가
         * 호출되기 전까지 heap에 지속적으로 쌓이게 되는 것이다.
         * 메모리 관리적인 측면에서 critical하다고 볼 수 있다.
         */

        /**
         * String class의 내부를 살펴보면 value[]라는 char형의 배열이
         * private final char형이라는 것을 보아야한다.
         * String에서 저장되는 문자열은 char형의 배열형태로 저장되는 것이며
         * 이 값들은 외부에서 접근하지 못하도록 private로 보호된다.
         * 또한 final 형이기 때문에 초기값으로 주어진 String값은 불변으로
         * 바뀔 수가 없게 되는 것이다.
         */

        /**
         * StringBuilder와 StringBuffer는 memory에 값을 append하는 방식을 사용하는데
         * 이를 알아보면
         * StringBuilder의 경우 변경가능한 문자열이지만 synchronization이 적용되지 않았고
         * StringBuffer의 경우 thread-safe라는 말에서처럼 변경할 수 있지만 multiple thread환경에서 안전하다고 한다.
         * 이 두개를 비교 테스트 해보자면
         */

        StringBuffer strBuffer = new StringBuffer();
        StringBuilder strBuilder = new StringBuilder();

        new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                strBuffer.append(i);
                strBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                strBuffer.append(i);
                strBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);

                System.out.println("StringBuffer.length : " + strBuffer.length());
                System.out.println("StringBuilder.length : " + strBuilder.length());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        /**
         * 이렇게 코드를 실행했을 때 서로 다른 값이 나오는 것을 알 수 있다.
         * StringBuilder의 값이 더 작은데
         * 이는 Thread들이 동시에 StringBuilder클래스에 접근할 수 있기 때문이다.
         * StringBuffer의 걍우 multi thread 환경에서 다른 값을 변경하지 못하도록 하므로
         * web이나 소켓환경과 같이 비동기로 동작하는 경우가 많을 때는 StringBuffer를 사용하는 것이
         * 안전하다고 할 수 있을 것이다.
         */
    }
}
