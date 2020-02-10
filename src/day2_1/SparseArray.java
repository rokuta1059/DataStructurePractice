package day2_1;

/**
 * 희소 배열을 만드는 클래스
 */
public class SparseArray {

    private Node head;	// 연결 리스트의 헤드
    private int size;	// 리스트의 크기

    /**
     * 생성자
     * @param size 리스트의 크기
     */
    public SparseArray(int size) {
        this.size = size;
        head = null;
    }

    /**
     * 인덱스와 값을 읽어 연결 리스트에 추가한다
     * @param index 추가할 위치 인덱스
     * @param value 인덱스에 추가할 값
     */
    public void set(int index, int value) {

        // 리스트가 비어있을 경우 리스트의 헤드에 추가한다
        if (head == null)
            head = new Node(index, value);

        // 리스트가 비어있지 않을 경우
        // 리스트를 탐색해서 지정된 위치를 탐색 후 저장한다.
        else{
            Node prev = null;
            Node curr = head;

            // 노드가 존재할 경우
            while(curr != null) {

                // 추가하려는 노드가 현재 탐색중인 인덱스보다 클 경우
                // 탐색을 중단한다.
                if(curr.index > index)
                    break;

                // 추가하려는 노드가 이미 리스트에 존재할 경우
                // 해당 인덱스의 값을 변경하고 return한다.
                else if(curr.index == index) {
                    curr.value = value;
                    return;
                }

                // 그 외의 경우
                // 다음 노드를 탐색한다.
                else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            // 노드를 새로 생성한 후
            // 현재 위치에 노드를 추가한다.
            Node newNode = new Node(index, value);
            newNode.next = curr;
            // 리스트의 첫 번째일 경우
            if(prev == null)
                head = newNode;
            // 그 외의 경우
            else
                prev.next = newNode;
        }

    }

    /**
     * 리스트를 출력한다.
     */
    public void print() {
        Node printNode = head;
        for(int i = 0; i <= size; i++) {
            // 인덱스를 출력한다.
            System.out.print("[" + i + "] ");

            // 해당 노드가 존재하지 않을 경우
            // 0을 출력한다
            if(printNode == null || printNode.index != i)
                System.out.println("0");

            // 해당 노드가 존재할 경우
            // 해당 값을 출력하고 노드를 다음 노드로 이동한다.
            else {
                System.out.println(printNode.value);
                printNode = printNode.next;
            }
        }
    }

}
