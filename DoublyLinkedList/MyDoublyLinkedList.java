package org.sopt.DoublyLinkedList;

/**
 * Doubly Linked List(이중 연결 리스트)는
 * Simple Linked List(단순 연결 리스트)의 경우에 노드의 접근이 단방향으로만 가능하기 때문에
 * N개의 노드가 존재한다면 평균 N/2의 노드의 탐색이 필요하다.
 * 그러나 이중 연결 리스트의 경우 다음 노드를 참조하는 nextNode와 그 전 노드를 참조하는 previousNode가 존재하기 때문에
 * 양방향으로 노드의 접근이 가능하다.
 * 즉, 처음과 가까운 노드는 순방향으로, 마지막과 가까운 노드는 역방향으로 탐색하면 되기 때문에
 * 순방향으로만 접근 가능한 단순 연결 리스트에 비해서 두배 정도의 빠른 검색효울을 가질 수 있다.
 */

import org.w3c.dom.Node;

/**
 * 순수한 검색기능만이 아니라 지정한 위치에 데이터를 삽입하거나 삭제하는 경우에도
 * 해당 위치의 앞, 뒤 노드를 꺼낸 후에 값을 수정해야하기 때문에 노드의 검색작업이
 * 먼저 이루어지므로 노드의 삽입, 삭제, 검색에 모두 좋은 효율을 가지게 된다.
 */

public class MyDoublyLinkedList {

    private Node header;
    private Node tail;
    private int size;
    public MyDoublyLinkedList(){
        size = 0;
    }

    /**
     * Node 클래스는 데이터를 가지며, 처음 노드와 마지막 노드의 참조를 가리키고 있다.
     * 단순 연결 리스트의 노드와 비교하여 이전 노드의 참조를 나타내는 prev가 추가되었다.
     * 첫 번째 노드일 경우는 prev의 값이 null이 되고, 마지막 노드일 경우는 next 값이 null이 된다.
     * header는 next의 첫번째 노드를 가리키고 prev는 마지막 노드를 가리킨다.
     */

    private class Node{
        //단일 연결 리스트와의 차이점은 이전 노드를 기록할 수 있는 변수를 가지고 있디.
        private Node next;
        private Node prev; // => 바로 이것!
        private Object data;

        Node(Object data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * DoublyLinkedList(이중 연결 리스트)의 경우 데이터 탐색은
     * 단순 연결 리스트의 탐색에서 index가 처음에 가까운지 마지막에 가까운지
     * 판별하여 처음에 가까우면 순방향 탐색, 마지막에 가까우면 역방향 탐색이 실행되는
     * 논리를 추가하기만 하면된다!
     * 즉, index가 (size/2)보다 크거나 같으면 순방향 탐색을 하고, 그 반대인 경우 역방향 탐색을 하면 된다
     * 그렇게 되면 평균 탐색 노드의 수는 N/4가 되는데 단순 열결 리스트의 1/2배의 실행시간을 가지게 된다.
     */

    public Object get(int index){
        return getNode(index).data;
    }

    public Object getFirst(){
        return get(0);
    }

    public Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index : " + index + "size : " +size);
        }

        Node node = header.next;

        if(index < (size/2)){
            for(int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {
            for(int i = size; i > index; i--){
                node = node.prev;
            }
            return node;
        }
        // 위의 조건식을 아래의 조건식으로도 대체할 수 있디.
        // for(int i = 0; i < size - index; i++){
        //      node = node.prev;
        //  }
        //  return node;
    }

    // obj 데이터와 같은 노드의 위치를 반환한다.
    private int getNodeIndex(Object obj){

        if(size<=0){
            return -1;
        }

        int index = 0;
        // 첫번째 노드를 가져온다.
        Node node = header.next;
        Object nodeData = node.data;

        // 첫 번째 노드부터 같은 데이터를 가진 노드를 탐색한다.
        while(!obj.equals(nodeData)){

            node = node.next;

            if(node==null){
                return -1;
            }

            nodeData = node.data;
            index++;
        }

        //위치를 반환!
        return index;
    }
   /**
     * Doubly Ended List(이중 연결 리스트)의 첫 번째에 데이터 삽입할 때는
     * 신규데이터를 이중 연결 리스트의 제일 첫 부분에 대입한다. 언뜻 보았을 때는
     * prev와 next참조를 모두 바꿔주어야 하기 때문에 복잡해보일 수 있다.
     */

    public void addFirst(Object data) {

        //데이터를 담은 새로운 노드 생성
        Node newNode = new Node(data);

        //새로운 노드가 다음 노드로 첫 번째 노드를 가리킨다.
        newNode.next = header.next;

        //리스트가 비어있지 않다면
        if (header.next != null) {

            //첫 노드가 자신의 앞 노드로 새로운 노드를 가리킨다.
            header.next.prev = newNode;

        } else { //리스트가 비어있다면

            // 헤더가 마지막 노드를 새로운 노드로 가리키도록 한다.
            header.prev = newNode;
        }

        //헤더가 첫 번째 노드로 새로운 노드를 가리키도록 한다.
        header.next = newNode;
        size++;
    }

    /**
     * 리스트의 index 위치에 데이터 삽입하는 경우에는 prev와 next를 꺼낸다.
     * 새로운 노드를 생성하고, 이전 노드의 nextNode와 다음 노드의 prevNode 값을 생성한 노드로 지정한다.
     * 단 이전 노드의 nextNode가 null이 아닌 경우. 즉, 삽입할 노드가 마지막 위치가 아닌 경우에만
     * 다음 노드가 존재하는 것이므로 prevNode 값을 지정하고, 삽입할 노드가 마지막 노드일 경우에는
     * 헤더의 이전 노드 값이 마지막 노드를 가리켜야 하므로 생성한 노드를 지정한다.
     * 그리고 생성한 노드의 prevNode와 nextNode를 각각 prev와 next로 지정한다.
     * 마지막으로 리스트의 사이즈를 하나 증가시킨다.
     */

    public void add(int index, Object data){
        //index가 0인 경우 맨 앞에 데이터 삽입!
        if(index == 0){
            addFirst(data);
        }

        //삽입할 index 위치의 앞 노드를 가져온다.
        Node prev = getNode(index-1);
        //삽입할 index 위치의 다음 노드를 가져온다,
        Node next = prev.next;

        //data로 새로운 노드 생성
        Node newNode = new Node(data);

        //앞 노드가 새로운 노드를 다음 노드로 가리킨다.
        prev.next = newNode;

        //새로운 노드가 앞 노드를 이전 노드로 가리킨다.
        newNode.prev = prev;

        //새로운 노드의 다음 노드에 다음 노드를 지정한다.
        newNode.next = next;

        //삽입 위치가 마지막 위치가 아니면
        if(newNode.next != null ){

            //다음 노드가 새로운 노드를 앞 노드로 지정한다.
            next.prev = newNode;
        } else {
            //삽입 위치가 마지막이면
            //헤더가 가리키는 마지막 노드가 새로운 노드가 된다.
            header.prev = newNode;
        }

        size++;
    }

    //마지막 노드에 삽입한다.
    public void addLast(Object data){
        add(size, data);
    }

    //데이터를 마지막에 넣는다.
    public void add(Object data){
        addLast(data);
    }

    /**
     * 데이터의 삭제의 경우 첫 노드의 삭제는 쉽다.
     * 헤더의 다음 노드를 두번째 노드를 가리키게 하고, 두번째 노드가 앞노드를 아무것도 가리키지 않게 하면
     * 자동적으로 첫번째 노드는 연결에서 끊어져 리스트에서 제거된다.
     */

    public Object removeFirst(){

        //첫번째 노드를 가져온다.
        Node first = getNode(0);

        //헤더가 첫 노드로 두번째 노드를 가리킨다.
        header.next = first.next;

        //리스트가 비어있지 않을 때
        if(header.next != null){

            // 두번째 노드가 가리키는 앞노드는 없는 것으로 해준다.
            first.next.prev = null;
        } else {
            //리스트가 비게되면 헤더가 가리키는 마지막 노드가 없다.
            header.prev = null;
        }

        size--;

        //첫번째 노드의 데이터를 반환!
        return first.data;
    }

    /**
     * index 번째의 데이터를 삭제하는 경우
     * 먼저 삭제할 노도를 검색하여 꺼낸 뒤 prevNode와 nextNode 속성을 이용하여
     * 이전 노드(prev)와 다음 노드(next)를 꺼낸다. 그리고 이전 노드의 nextNode값을 next로 지정하고
     * 다음 노드의 prevNode값을 prev로 지정한다!
     * 단 next 노드가 null이 아닌 경우, 즉, 삭제할 노드가 마지막 노드가 아닐 경우에만
     * 다음 노드가 존재하므로 다음 노드의 prevNode값을 지정하고 삽입할 노드가 마지막 노드일 경우에는
     if* 헤더의 이전 노드 값이 마지막 노드를 가리켜야하므로 prev를 지정한다.
     *
     * 마지막에는 리스트의 크기를 하나 감소시키고 삭제한 노드의 데이터를 반환한다.
     */

    public Object remove(int index){

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }else if(index==0){
            return removeFirst(); // index가 0일 경우 첫번째 데이터 제거
        }

        // 제거할 index 위치의 노드를 가져온다.
        Node removeNode = getNode(index);
        // 제거할 노드의 앞노드를 가져온다.
        Node previous = removeNode.prev;
        // 제거할 노드의 뒷노드를 가져온다.
        Node next = removeNode.next;

        // 앞노드가 다음노드를 다음으로 가리킨다.
        previous.next = next;

        // 제거되는 노드가 마지막 노드가 아니면
        if(next!=null){

            //제거 노드의 뒷노드가 앞노드로 제거 노드 앞 노드를 가리킨다.
            next.prev = previous;

        }else{

            // 제거 노드가 마지막 노드면 헤더가 마지막 노드로 앞노드를 가리킨다.
            header.prev = previous;

        }

        size--;

        // 제거노드의 데이터를 반환
        return removeNode.data;
    }

    //데이터를 제거한다.
    public boolean remove(Object data){

        // data가 있는 index를 얻는다.
        int nodeIndex = getNodeIndex(data);

        // 데이터가 없으면 false를 반환
        if(nodeIndex == -1){
            return false;
        }else{
            //데이터가 있다면 제거!
            remove(nodeIndex);
            return true;
        }
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public int size(){
        return size;
    }

    public String toString(){

        StringBuffer result = new StringBuffer("[");
        Node node = header.next;

        if(node != null){
            result.append(node.data);
            node = node.next;

            while(node!=null){
                result.append(", ");
                result.append(node.data);
                node = node.next;
            }
        }

        result.append("]");
        return result.toString();
    }
}

