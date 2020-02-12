package day_3;

/**
 * Stack의 상속 클래스
 * @author 김우섭
 *
 * @param <T>
 */
class LinkedStack<T> implements Stack<T>{

    private static class Node<T> {
        private T item;
        private Node<T> next;
        /**
         * 구성자
         */
        private Node() {
            next = null;
        }
        private Node(T item) {
            this.item = item;
            next = null;
        }
        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * LinkedStack의 내용을 없애고
     * 새로운 LinkedStack을 만든다
     */
    public void clear() {
        Node<T> newHead = new Node<T>();
        head = newHead;
        size = 0;
    }

    /**
     * LinkedStack이 비어있는지 판단하여
     * 비어있는 경우 true, 그렇지 않은 경우 false를 반환
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 현재 LinkedStack에서 가장 나중에 저장된 값을 보여준다
     */
    public T peek() {
        if(isEmpty())
            throw new java.util.EmptyStackException();
        return head.item;
    }

    /**
     * 현재 LinkedStack에서 가장 나중에 저장된 값을 빼내어 보여준다
     * peek와는 다르게 나중에 저장된 값이 빼내어지면서 사라진다
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
     * LinkedStack에 값을 새로 저장한다
     */
    public void push(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * LinkedList의 크기를 반환한다.
     */
    public int size() {
        return size;
    }

    /**
     * LinkedList의 배열의 구성을 출력한다.
     */
    public String toString() {
        Node <T> newNode = head;
        StringBuilder sb = new StringBuilder();
        for(int i = size - 1; i > 0; i--) {
            sb.append(newNode.item + " ");
            newNode = newNode.next;
        }
        sb.append(newNode.item);
        return sb.toString();

    }


}
