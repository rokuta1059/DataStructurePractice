package day_2_1;

public class Node {

    public int index;
    public int value;
    public Node next;

    /**
     * 생성자
     * @param index 현재 노드의 위치 인덱스
     * @param value 값
     */
    public Node(int index, int value) {
        this.index = index;
        this.value = value;
        next = null;
    }

    public Node() {
        next = null;
    }

}
