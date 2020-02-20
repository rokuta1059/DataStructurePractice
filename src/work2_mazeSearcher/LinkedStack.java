package work2_mazeSearcher;

class LinkedStack<T>{

    private class Node<T> {

        private T item;
        private Node<T> next;

        private Node(T item) {
            this(item, null);
        }

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> head = null;
    private int size;


    /**
     * Stack이 비어있는지 확인하는 메소드
     * @return 비어있으면 true, 비어있지 않으면 false를 반환한다.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Stack에 쌓여있는 Node의 수를 확인하는 메소드
     * @return 쌓여있는 Node의 수
     */
    public int size() {
        return size;
    }

    /**
     * Stack에 Node를 추가한다.
     * @param item 추가할 Node에 들어갈 값
     */
    public void push(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Stack에서 맨 나중에 저장된 값을 반환한다.
     * @return 반환한 Node의 item값
     */
    public T pop() {
        if(isEmpty())
            throw new java.util.EmptyStackException();
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    /**
     * Stack에서 맨 나중에 저장된 값을 보여준다.
     * @return 맨 마지막의 Node에 저장된 item값
     */
    public T peek() {
        if(isEmpty())
            throw new java.util.EmptyStackException();
        return head.item;
    }

    /**
     * Stack을 초기화한다.
     */
    public void reset() {
        head = null;
        size = 0;
    }
}
