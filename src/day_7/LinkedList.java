package day_7;

class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T item) {
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty())
            throw new java.util.NoSuchElementException
                    ("remove(): list empty");
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            if (curr.item.equals(item))
                break;
            prev = curr;
            curr = curr.next;
        }

        if (curr == null)
            return false;
        else if (prev == null)
            head = head.next;
        else
            prev.next = curr.next;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean search(T item) {
        if (isEmpty())
            throw new java.util.NoSuchElementException
                    ("search(): list empty");
        Node<T> scan = head;
        while (scan != null) {
            if (scan.item.equals(item)) {
                return true;
            }
            scan = scan.next;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> scan = head;
        while (scan != null) {
            sb.append(scan.item);
            scan = scan.next;
        }
        return sb.toString();
    }

    public void print() {
        String s = new String();
        Node<T> scan = head;
        while (scan != null) {
            System.out.print(scan.item + " ");
            scan = scan.next;
        }
        System.out.println();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void delete(int num) {    // num 번째 노드를 삭제
        Node<T> prev = null;
        Node<T> curr = head;
        for (--num; num > 0; num--) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null)
            head = head.next;
        else
            prev.next = curr.next;
        --size;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(head);
    }


}
