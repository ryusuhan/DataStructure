package org.sopt.DoubleEndedLinkedList;

import org.w3c.dom.Node;
/**
 * Simple Linked List(단순 연결 리스트)의 경우 맨 위의 요소들의 삽입과 섹제에
 * 빠른 처리속도를 보이지만 마지막 요소의 삽입과 삭제에는 처음부터 끝까지 순차적으로 검색하며
 * 마지막 노드를 찾아야 하기 때문에 저장된 데이터가 많아질 수록 효율이 떨어진다.
 *
 * Double Ended Linked List(이중 말단 연결 리스트)는 Header에
 * 첫 노드와 마지막 노드를 참조하여 Simple Linked List의 문제를 해결한다.
 */

/**
 * Simple Linked List(단순 연결 리스트)는 첫 노드의 삽입과 삭제의 효율이 좋으므로
 * 첫 노드의 데이터를 꺼내는 작업에 좋은 효율을 가지므로 LIFO(후입선출)구조인 Stack에 유리하고
 *
 * Double Ended Linked List(이중 말단 연결 리스트)는 리스트의 마지막 노드에 데이터를 저장하고
 * 첫 노드에서 데이터를 꺼내는 작업에 좋은 효율을 가지므로 FIFO(선입선출)구조를 가지는
 * Queue를 구현하는데 좋은 방법이다.
 */



/**
 * 리스트에 새로운 데이터를 삽입, 삭제할 경우 단순 연결 리스트와 동일한 방식으로 처리하면 되지만
 * 삽입 삭제되는 노드가 마지막 노드가 되는 경우 헤더의 마지막 노드에 대한 참조를 수정해주는 부분을 추가적으로 고려하여
 * 작성하면 구현할 수 잇다.
 */
public class MyDoubleEndedLinkedList {

    private Header header;
    private int size;

    private org.w3c.dom.Node nextNode;
    private org.w3c.dom.Node lastNode;

    public MyDoubleEndedLinkedList(){
        header = new Header();
        size = 0;
    }

    /**
     * Header 클래스는 이중 말단 연결 리스트의 첫 노드를 참조하는 nextNode와
     * 마지막 노드를 참조하는 lastNode로 구성된다.
     */
    public class Header{
        private org.w3c.dom.Node nextNode;
        private org.w3c.dom.Node lastNode;

        Header(){
            nextNode = null;
            lastNode = null;
        }
    }

    /**
     * Node의 경우 단순 연결 리스트와 구조가 같다. (data와 nextNode를 가진다.)
     * 단순 연결 리스트의 경우 Nide 클래스를 헤더와 겸용으로 사용했지만
     * Double Ended Linked List(이중 말단 연결 리스트)는 헤더가 마지막 노드를 참조해야 하므로
     * 위와 같이 Header 클래스를 별로도 작성했다.
     */
    private class Node{

        private Object data;
        private org.w3c.dom.Node nextNode;

        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }

    /**
     * Double Ended Linked List(이중 말단 연결 리스트)의 삽입의 경우
     * 리스트의 처음이나 마지막에서 이뤄질 수 있다!
     */

    /**
     * 리스트의 첫부분에 삽입되는 경우 header가 가리키던 맨 처음 노드를 newNode가 가리키게 하고
     * header.nextNode를 newNode가 가리키게 하고 size를 하나 올려준다.
     * 이 때 newNode.nextNode가 null이라면 리스트에 들어있는 노드가 한개 뿐인 상황이므로
     * header.nextNode가 newNode를 가리키게 해야한다.
     *
     * 기본적인 구조는 단순 연결 리스트와 같지만 새로운 노드의 nextNode 값이 null이라면
     * 새로운 노드가 리스트의 마지막 노드면 header의 lastNode를 새로운 노드로 지정하는 코드가
     * 추가되었다.
     */

    // 리스트의 첫번째에 data를 삽입한다.
    public void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.nextNode = header.nextNode;
        header.nextNode = (org.w3c.dom.Node) newNode;
        size++;

        if(newNode.nextNode == null){
            header.lastNode = (org.w3c.dom.Node) newNode;
        }
    }

    /**
     * 리스트의 마지막 부분에 삽입하는 것은 헤더가 가지고 있던 기존의 마지막 노드가
     * 새로 삽입되는 newNode를 가리키게 header.lastNode.nextNode = new Node라고
     * 해준 뒤 header.lastNode = newNode라고 해주어야 한다.
     */

    // 리스트의 마지막에 data를 삽입한다.
    public void addLast(Object data){

        Node last = (Node) header.lastNode;

        if(header.lastNode == null){
            addFirst(data);
        }else{
            Node newNode = new Node(data);
            last.nextNode = (org.w3c.dom.Node) newNode;
            header.lastNode = (org.w3c.dom.Node) newNode;
            size++;
        }
    }

    //index의 위치에 data를 삽입한다.
    public void add(int index, Object data){

        if(index == 0){

            addFirst(data);
            return;

        }else if(index == size){
            addLast(data);
        }else{

            Node previous = getNode(index-1);
            Node next = (Node) previous.nextNode;
            Node newNode = new Node(data);
            previous.nextNode = (org.w3c.dom.Node) newNode;
        }
    }

    // data를 리스트의 마지막에 삽입한다.
    public void add(Object data){
        addLast(data);
    }

    /**
     * 데이터의 겁색은 단순 연결리스트와 같다.
     */

    //index 번째 노드의 데이터를 반환!
    public Object get(int index){
        return getNode(index).data;
    }

    //첫번째 노드의 데이터를 반환!
    public Object getFirst(){
        return get(0);
    }

    //index 번째의 노드를 반환하는 메소드!
    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        Node node = (Node) header.nextNode;
        for(int i = 0; i < index; i++){
            node = (Node) node.nextNode;
        }

        return node;
    }

    //해당 데이터의 노드 위치 index를 반환한다.
    public int getNodeIndex(Object obj){

        if(size<=0){
            return -1;
        }

        int index=0;
        Node node = (Node) header.nextNode;
        Object nodeData = node.data;

        //header에서 부터 순차적으로 nodeData와 값을 비교한다.
        while(!obj.equals(nodeData)){
            node = (Node) node.nextNode;

            if(node==null){
                return -1;
            }

            nodeData = node.data;
            index++;
        }

        return index;
    }

    /**
     * 데이터의 삭제의 경우 단순 연결리스트와 마찬가지로 첫 노드에서 효율적이다.
     * 헤더가 가리키는 첫 노드에 대한 참조를 두번째 노드로 바꿔주면 된다.
     * 또한 삭제된 노드가 마지막 노드였을 경우에는 마지막 노드 참조값을 null로 바꿔준다.
     */

    /**
     * 기본 코드는 단순 연결 리스트와 같지만 헤더의 NextNode값이 null일 경우
     * 즉, 삭제한 노드가 리스트의 마지막 노드였을 경우 헤더의 lastNode를 null로 지정하는 부분이 추가되었다.
     */

    /**
     * 이중 말단 리스트는 lastNode를 참조하고 있어서 리스트의 마지막 노드에 삽입도 효율적이었지만
     * 삭제에서는 마지막 노드를 바로 삭제할 수 없다. 마지막 노드를 삭제하면, 헤더의 lastNode가 마지막 -1노드를
     * 참조해야하는데 마지막 01노드를 찾으려면, 리스트의 앞에서부터 탐색해가야한다.
     */

    // 첫 노드를 삭제한다.
    public Object removeFirst(){

        Node first = getNode(0);
        header.nextNode = first.nextNode;
        size--;

        if(header.nextNode == null){
            header.lastNode = null;
        }

        return first.data;
    }

    // 마지막 노드를 삭제한다.
    public Object removeLast(){
        return remove(size-1);
    }

    //해당 인덱스의 노드를 삭제한다.
    public Object remove(int index){

        if(index<0 || index >= size){

            throw new IndexOutOfBoundsException("Index : " + index + ", Size :" +size);

        }else if(index==0){
            return removeFirst();
        }

        Node previous = getNode(index-1);
        Node removeNode = (Node) previous.nextNode;
        Node next = (Node) removeNode.nextNode;
        previous.nextNode = (org.w3c.dom.Node) next;
        size--;

        if(previous.nextNode == null){
            header.lastNode = (org.w3c.dom.Node) previous;
        }

        return removeNode.data;
    }

    // 해당 data가 있는 노드를 삭제한다.
    public boolean remove(Object data){

        int nodeIndex = getNodeIndex(data);

        if(nodeIndex == -1){
            return false;
        }else{
            remove(nodeIndex);
            return true;
        }
    }

    // 리스트의 크기를 반환한다.
    public int size(){
        return size;
    }

    //리스트 데이터를 String으로 반환!
    public String toString(){

        StringBuffer result = new StringBuffer("[");
        Node node = (Node) header.nextNode;

        if(node != null){
            result.append(node.data);
            node = (Node) node.nextNode;

            while(node != null){
                result.append(", ");
                result.append(node.data);
                node = (Node) node.nextNode;
            }
        }

        result.append("]");
        return result.toString();
    }





}
