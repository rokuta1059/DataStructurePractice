package day_7;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> scanPos;

    public LinkedListIterator(Node<T> head) {
        scanPos = head;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return scanPos != null;
    }

    @Override
    public T next() {
        // TODO Auto-generated method stub
        T item = scanPos.item;
        scanPos = scanPos.next;
        return item;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

}
