package org.sopt.SimpleLinkedList;

import org.w3c.dom.Node;

/**
 * Simple Linked List(단순 연결 리스트)란
 * 각 노드들이 다음 노드를 가리키는 하나의 참조만을 가진다
 * 노드의 접근은 한 방향이다
 * 헤더는 첫 노드를 가리키고, 마지막 노드는 null을 가리키게 된다.
 * Header는 첫 노드를 가리키면서 요소의 수를 나타내는 size를 가지고 있다
 * Node는 값을 저장하는 Data와 다음 노드를 가리키는 nextNode를 가지고 있다.
 */

public class MySimpleLinkedList {

        //왜 private로 하는가?
        //=> Header와 size는 모두 LinkedList를 통해서만 접근하기 땨문!
        private Node header;
        private int size;

        MySimpleLinkedList(){
            // 가리킬 수 있는 첫 노드를 생성하고 이를 Header가 가리켜야 한다!
            header = new Node(null);
            // size는 요소의 수를 나타내는 변수
            size = 0;
        }

        private class Node {
            //다음 노드를 가리키는 nextNode를 가지고 있어야한다.
            //data는 각 노드에 저장되는 object가 될 것이다.
            private Node nextNode;
            private Object data;

            Node(Object data) {
                this.data = data;
                //마지막 Node는 null을 가리킨다.
                nextNode = null;
            }
        }

            /**
             * Simple Linked List(단순 연결 리스트)의 데이터 삽입은
             * Header다음(=> 맨앞)에 삽입되어야 한다.
             * 맨 뒤에 삽입 되기 위해서는 단방향으로 노드의 접근이 가능한
             * 단순 연결 리스트의 성격상 맨 마지막 Node까지 접근한 이후에 Data 삽입이 가능하기 때문!
             */

            public void addFirst(Object data){

                Node newNode = new Node(data);
                newNode.nextNode = header.nextNode;
                header.nextNode = header.nextNode;
                header.nextNode = newNode;
                size++;
            } // 1. data를 넣어 새로운 newNode를 생성한다.
              // 2. newNode.nextNode가 header.nextNode를 가리키게한다.
              // 3. header.nextNode는 newNode를 가리키게 한다.
              // 4. size를 증가시킨다.

            /**
             * Simple Linked List(단순 연결 리스트)에서의 데이터 검색은
             * index를 받아와 해당하는 Node의 data를 return하는 메소드이다.
             */

            public Node getNode(int index){
                //인자의 index값이 정상 범위의 값인지 확인한다.
                if(index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException("Index" + index + ", Size" + size);
                }

                //header에서 부터 해당 index 수만큼 nextNode로 이동한다.
                Node node = header.nextNode;
                for(int i = 0; i < index; i++){
                    node = node.nextNode;
                }

                return node;
            }

            //지정한 위치의 데이터를 가져오기 위해서는 get() 메소드를 사용!
            public Object get(int index){
                //get() 메소드에서는 getNode() 메소드를 사용해서 지정한
                //index의 노드를 가져와서 해당 노드의 data를 반환한다.
                return getNode(index).data;
            }
            // 1. 인자의 index값이 정상 범위의 값인지 확인한다.
            // 2. header에서 부터 해당 index 수만큼 nextNode로 이동한다.

            /**
             * Simple Linked List(단순 연결 리스트)에서 데이터의 삭제는
             * 리스트의 첫 번째 노드에서 삭제시 효율적으로 이루어진다.
             * 첫 번째 노드의 데이터를 삭제시 헤더가 노드에 대한 참조를
             * 두번째 노드로 바꿔주면 된다.
             */

            public Object removeFirst(){
                //먼저 삭제할 노드인 첫 노드를 꺼낸다.
                Node firstNode = getNode(0);
                //헤더의 첫 노드를 가리키는 nextNode 값을 두번째 노드로 지정한다.
                header.nextNode = firstNode.nextNode;
                size--;
                // 삭제한 노드의 데이터를 반환한다.
                return firstNode.data;
           }
            //먼저 삭제할 노드인 첫 노드를 꺼낸 뒤 헤더의 첫 노드를 가리키는 nextNode 값을
            //두번째 노드로 지정하고, 데이터를 하나 삭제했으므로 리스트의 크기를 하나 감소시킨다.
            //마지막으로 삭제한 노드의 데이터를 반환한다.

            public Object getFirst(){
                return get(0);
            }
            //첫번째 노드의 데이터를 반환하는 메소드

            //데이터로 해당 데이터가 있는 노드의 index를 가져오는 메소드
            public int getNodeIndex(Object obj){
                if(size<=0){
                    return -1;
                }

                int index = 0;
                Node node = header.nextNode;
                Object nodeData = node.data;

                //header에서 부터 순차적으로 nodeData와 값을 비교!
                while(!obj.equals(nodeData)){
                    node = node.nextNode;

                    if(node==null){
                        return -1;
                    }

                    nodeData = node.data;
                    index++;
                }

                return index;
            }

            //index의 위치에 data를 삽입한다.
            public void add(int index, Object data){

                if(index==0){
                    addFirst(data);
                    return;
                }

                //지정한 index보다 하나 낮은 인덱스의 Node와 해당 index의 Node를 불러온다.
                Node previous = getNode(index-1);
                Node next = previous.nextNode;

                //새로 만든 노드를 이전 index의 노드 뒤로 지정한다.
                Node newNode = new Node(data);
                previous.nextNode = newNode;

                //새로 만든 노드의 다음 노드를 해당 인덱스의 노드로 지정해준다.
                newNode.nextNode = next;
                size++; // size를 하나 늘려준다.
            }

            //리스트의 마지막에 data를 삽입하는 메소드
            public void addLast(Object data){
                add(size, data);
            }

            //리스트의 마지막에 data를 삽입하는 메소드
            public void add(Object data){
                addLast(data);
            }

            //index 위치의 노드를 제거하고 데이터를 반환하는 메소드
            public Object remove(int index){

                if(index < 0 || index>=size){

                    throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);

                }else if(index == 0){
                    return removeFirst();
                }

                //해당 인덱스 이전의 노드와 해당 인덱스의 노드와 해당 인덱스 다음의 노드를 가져와서
                //이전 노드의 다음 노드 값을 해당 인덱스 다음의 노드로 지정해준다.
                Node previous = getNode(index-1);
                Node removeNode = previous.nextNode;
                Node next = removeNode.nextNode;
                previous.nextNode = next;
                size--; //하나가 삭제 되었으므로 사이즈를 줄여준다.

                return removeNode.data;//삭제된 노드의 데이터를 가져온다.
            }

            //리스트의 마지막 노드를 제거하고 데이터를 반환하는 메소드
            public Object removeLast(){
                return remove(size-1);
            }

            public void remove(Object data){
                int idx = getNodeIndex(data);
                remove(idx);
            }

            //리스트의 사이즈를 반환하는 메소드
            public int size(){
                return size;
            }

            //리스트의 데이터를 String형으로 반환하는 메소드
            public String toString(){

                StringBuffer result = new StringBuffer("[");
                Node node = header.nextNode;

                if(node != null){
                    result.append(node.data);
                    node = node.nextNode;

                    while(node != null){
                        result.append(", ");
                        result.append(node.data);
                        node = node.nextNode;
                    }
                }

                result.append("]");
                return result.toString();
            }

        }
