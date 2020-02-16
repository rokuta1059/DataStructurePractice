package day_7;

/**
 * 반복자 클래스
 * @param <T>
 */
public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> scanPos;

    /**
     * 생성자
     * @param head
     */
    public LinkedListIterator(Node<T> head) {
        scanPos = head;
    }

    /**
     * 다음 노드가 존재하는지 확인한다.
     * @return true (다음 노드가 존재할 경우)
     *         false (다음 노드가 존재하지 않은 경우)
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return scanPos != null;
    }

    /**
     * 반복자가 현재 가리키는 노드를 반환하고
     * 반복자를 다음 노드로 이동한다.
     * @return 현재 노드
     */
    @Override
    public T next() {
        // TODO Auto-generated method stub
        T item = scanPos.item;
        scanPos = scanPos.next;
        return item;
    }

    /**
     * 현재 노드를 제거한다. (구현되지 않음)
     */
    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

}
