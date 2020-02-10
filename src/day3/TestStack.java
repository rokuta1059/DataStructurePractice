package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestStack {
    /**
     * 입력된 파일 안의 내용을 읽어들여
     * 괄호가 쌍이 맞는지 확인하는 메소드
     * @throws FileNotFoundException
     */
    public static void checkParenthesis() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("src/" +
                "day3/input.txt"));

        // 괄호를 저장할 스택을 생성한다
        LinkedStack<String> stack = new LinkedStack<String>();
        while(inFile.hasNextLine()) {
            String line = inFile.nextLine();
            for(int i = 0; i < line.length(); i++) {

                // 불러들인 파일을 줄단위로 끊은 다음 String 타입으로 저장한다
                String item = line.charAt(i) + "";
                System.out.print(item);

                // "("가 보일 때 마다 스택에 저장한다
                if(item.equals("(")) {
                    stack.push("(");
                }

                // ")"가 보일 때 마다 스택에서 pop을 호출한다
                // 단 아무것도 스택에 저장되지 않은 상황에서 pop을 호출시
                // 괄호가 이미 맞지 않는 상황이므로 스택에 ")"를 저장후 탐색이 바로 종료된다.
                // 스택에 ")"를 저장하는 이유는 "("가 남아 끝나는 경우와 분별하기 위함이다.
                else if(item.equals(")")) {
                    if(stack.isEmpty()) {
                        System.out.println();
                        System.out.print("Closing parenthesis is not matched");
                        stack.push(")");
                        break;
                    }
                    stack.pop();
                }
            }
            // 스택에 "("가 남아있을 시
            // 열림 괄호가 맞지 않는다는 오류메세지를 출력한다
            System.out.println();
            if(stack.isEmpty() == false) {
                if(stack.peek().equals("("))
                    System.out.println("Opening parenthesis is not matched");
            }
            else
                System.out.println("Parentheses matched.");
            stack.clear();
        }
        inFile.close();
    }

    /**
     * 정수로 된 배열 data[]가 주어졌을 때
     * 배열의 각 원소에서 그 원소보다 큰 원소를
     * 그 원소의 왼쪽부터 찾아 해당 인덱스를 저장하는 배열을 반환한다.
     * 만약 그 원소보다 큰 원소를 찾지 못한 경우 -1을 저장한다.
     * @param data 정수로 된 배열
     * @return 각 원소보다 큰 원소가 해당된 인덱스가 저장된 배열
     */
    public static int[] getLastAsBig(int[] data) {
        int[] asBig = new int[data.length];
        LinkedStack<Integer> stack = new LinkedStack<Integer>();

        // stack에 받아들인 배열을 저장한다
        for(int i = 0; i < data.length; i++) {
            stack.push(data[i]);
        }

        // stack에 아무것도 남지 않으면 실행종료
        while(!stack.isEmpty()) {
            int temp = stack.pop();

            // stack을 복사한 find LinkedStack을 만든다
            // 단순히 find = stack을 할 경우
            // find.pop()을 시행할 시 stack 또한 pop이 되는 경우가 확인됨

            LinkedStack<Integer> find = new LinkedStack<Integer>();
            for(int i = 0; i < stack.size();i++) {
                find.push(data[i]);
            }

            // find를 통해 큰 값이 들어있는 index를 찾는다
            while(!find.isEmpty()) {

                // 큰 값이 들어있는 index가 발견될 경우
                if(find.pop() > temp) {
                    asBig[stack.size()] = find.size();
                    break;
                }

                // 큰 값이 없는 경우
                else if(find.isEmpty())
                    asBig[stack.size()] = -1;
            }

            // 맨 왼쪽의 값은 무조건 자기 자신이 가장 크기 때문에
            // -1을 넣어준다
            if(stack.size() == 0)
                asBig[0] = -1;
            find.clear();

        }

        return asBig;
    }

    /**
     * 메인 메소드
     * 실습 과제에서 주어진 메소드를 활용한다.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        String command;
        int item;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command: push,pop,peek,size,b(find big) "
                + "m(test matching parenthesis), p(rint), or q(uit)");
        System.out.print("> ");
        command = in.next();
        while (!command.equals("q")) {
            if (command.equals("push")) {
                item = in.nextInt();
                stack.push(item);
            }
            else if (command.equals("pop"))
                stack.pop();
            else if (command.equals("peek")) {
                item = stack.peek();
                System.out.println("Top element is " + item);
            }
            else if (command.equals("size"))
                System.out.println("size: " + stack.size());
            else if (command.equals("p"))
                System.out.println(stack);
            else if (command.equals("m"))
                checkParenthesis();
            else if (command.equals("b")) {
                int[] data = {10, 5, 7, 2, 9, 15, 12, 3, 5, 14};
                int[] big = getLastAsBig(data);
                int i;
                System.out.print("[");
                for (i = 0; i < big.length-1; i++)
                    System.out.print(big[i] + ", ");
                System.out.println(big[i] + "]");
            }
            System.out.print("> ");
            command = in.next();
        }
        System.out.println("Commands terminated.");
        in.close();
    }
}
