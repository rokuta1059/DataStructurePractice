package day_7;

class Node<T> {

    public T item;
    public Node<T> next;

    public Node() {
    }

    public Node(T item) {
        this(item, null);
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }
}
