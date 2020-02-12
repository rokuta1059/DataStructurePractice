package day_5;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class unsortedLinkedTest {

	/**
	 * 테스트용 메인 메소드
	 * @param args
	 */
	public static void main(String[] args) {
		UnsortedLinkedList<Integer> list = new UnsortedLinkedList<Integer>();
		String command;
		int item, num;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a command: i(insert), r(emove), s(earch),size, append, ");
		System.out.println("insert, remove, retrieve, reverse, p(rint), or q(uit)");
		System.out.print("> ");
		command = input.next();

		while (true) {		
			if (command.equals("i")) {
				item = input.nextInt();
				list.insert(item);
			}
			else if (command.equals("r")) {
				item = input.nextInt();
				if (list.remove(item))
					System.out.println(item + " removed.");
				else
					System.out.println("No such " + item + "!");
			}		
			else if (command.equals("s")) {
				item = input.nextInt();
				if (list.search(item))
					System.out.println(item + " is in the list.");
				else
					System.out.println("No such " + item + "!");
			}
			else if (command.equals("size")) {
				System.out.println("size: " + list.size());
			}
			else if (command.equals("p"))
				System.out.println(list);
			
			else if (command.equals("reverse")) {
				UnsortedLinkedList<Integer> revList = reverse(list);
				System.out.println(revList);
			}
			else if (command.equals("insert")) {
				num = input.nextInt();
				item = input.nextInt();
				list.insert(num, item);
			}
			else if (command.equals("delete")) {
				num = input.nextInt();
				list.delete(num);
			}
			else if (command.equals("append")) {
				item = input.nextInt();
				list.append(item);
			}
			else if (command.equals("c")) {
				LinkedList<Integer> oddList = new LinkedList<>();
				LinkedList<Integer> evenList = new LinkedList<>();
				oddNEven(list, oddList, evenList);
				System.out.println("odd number: " + oddList);
				System.out.println("even number: " + evenList);
			}
			else if (command.equals("q"))
				break;
			System.out.print("> ");
			command = input.next();
		}
		System.out.println("Commands Terminated.");
		input.close();


	}

	/**
	 * 리스트를 역순으로 만들어 반환한다.
	 * @param list 리스트
	 * @return 역순으로 만들어진 리스트
	 */
	public static UnsortedLinkedList<Integer> reverse(UnsortedLinkedList<Integer> list) {
		if(list.isEmpty()) 
			throw new NoSuchElementException("remove(): list empty");
		list.reset();
		UnsortedLinkedList<Integer> newList = new UnsortedLinkedList<Integer>();
		while(list.hasNext()) {
			newList.insert(list.next());
		}
		return newList;
	}

	/**
	 * 입력받은 리스트를 짝수와 홀수 리스트로 나누어 반환한다.
	 * @param list 리스트
	 * @param oddList 홀수 리스트
	 * @param evenList 짝수 리스트
	 */
	public static void oddNEven(UnsortedLinkedList<Integer> list, LinkedList<Integer> oddList, LinkedList<Integer> evenList) {
		if(list.isEmpty()) 
			throw new NoSuchElementException("remove(): list empty");
		list.reset();
		while(list.hasNext()) {
			int i = list.next();
			if((i % 2)==0)
				evenList.add(i);
			else
				oddList.add(i);
		}
	}

}
