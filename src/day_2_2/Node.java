package day_2_2;

public class Node {

    public int item;
    public Node next;

    /**
     * 생성자
     * @param item 값
     * @param next 다음 노드
     */
    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(int item) {
        this(item, null);
    }

}
