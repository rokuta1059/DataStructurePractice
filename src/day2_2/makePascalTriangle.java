package day2_2;

/**
 * 파스칼 삼각형을 만드는 클래스
 * 연결 리스트를 이용해 구현한다.
 */
public class makePascalTriangle {

    public static void main(String[] args) {

        // 파스칼 삼각형의 크기와 배열을 생성한다.
        int rowSize = 12;
        Node[] triangle = new Node[rowSize];

        // 삼각형의 맨 윗부분에는 1을 추가한다.
        triangle[0] = new Node(1);

        // 탐색과 함께 값을 계산하여 추가해준다.
        for(int i = 1; i < rowSize; i++) {

            // 맨 처음에는 1을 추가한다.
            triangle[i] = new Node(1);
            Node temp = triangle[i];
            Node prevTemp = triangle[i-1];

            // 그 이후의 값을 계산한다
            for(int j = 1; j < i; j++) {
                int sum = prevTemp.item + prevTemp.next.item;
                temp.next = new Node(sum);
                temp = temp.next;
                prevTemp = prevTemp.next;
            }

            // 삼각형의 끝부분일 경우 1을 추가한다.
            temp.next = new Node(1);
        }

        // 파스칼 삼각형을 출력한다.
        for(int i = 0; i < rowSize; i++) {
            Node temp = triangle[i];
            while (temp != null) {
                System.out.print(temp.item + "\t");
                temp = temp.next;
            }
            System.out.println();
        }

    }


}
