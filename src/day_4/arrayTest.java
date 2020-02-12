package day_4;

import java.util.Scanner;

public class arrayTest {

    /**
     * 기수 정렬(Radix Sort)을 구현한다.
     */
    public static void radixSort() {

        final int MAX_ITEMS = 20;
        Integer[] items = new Integer[MAX_ITEMS];
        for (int i = 0; i < items.length; i++)
            items[i] = (int) (10000.0 * Math.random());
        System.out.print("정렬되지 않은 데이터: ");
        for (int i = 0; i < items.length; i++)
            System.out.print(items[i] + " ");
        System.out.println();

        int radix = 10;
        ArrayQueue<Integer>[] queues = new ArrayQueue[radix];
        for (int i = 0; i < radix; i++)
            queues[i] = new ArrayQueue<Integer>();

        int length = 4; // 숫자들의 최대 자릿수
        int front = 10; // 계산할 다음 자릿수
        int back = 1;   // 계산할 현재 자릿수
        for (int i = 0; i < length; i++) {

            // 현재 자릿수의 값을 계산한 후
            // 해당하는 위치의 자릿수 queue에 추가한다.
            for (int j = 0; j < items.length; j++) {
                int temp = (items[j] % front) / back;
                queues[temp].enqueue(items[j]);
            }

            // 자릿수 queue에서 낮은 자릿수부터 dequeue하여
            // 차례대로 배열에 넣는다
            int itemlength = 0;
            for (int j = 0; j < radix; j++) {
                while (!queues[j].isEmpty()) {
                    items[itemlength] = queues[j].dequeue();
                    itemlength++;
                }
            }

            // 차례대로 출력한다.
            System.out.print(back + "자리 정렬: \t");
            for (int j = 0; j < items.length; j++)
                System.out.print(items[j] + " ");
            System.out.println();
            front = front * 10;
            back = back * 10;
        }

    }

    /**
     * 실습 예제 코드
     *
     * @param args
     */
    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        String command;
        int item;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a command: e(nqueue), d(equeue), s(ize), peek, sort, p(rint), or q(uit)");
        System.out.print("> ");
        command = input.next();

        while (!command.equals("q")) {
            if (command.equals("e")) {
                item = input.nextInt();
                queue.enqueue(item);
            } else if (command.equals("d"))
                queue.dequeue();
            else if (command.equals("s"))
                System.out.println("size: " + queue.size());
            else if (command.equals("peek"))
                System.out.println("Front of the queue: " + queue.peek());
            else if (command.equals("p"))
                System.out.println(queue);
            else if (command.equals("sort"))
                radixSort();

            System.out.print("> ");
            command = input.next();
        }
        System.out.println("Commands Terminated.");
    }
}

