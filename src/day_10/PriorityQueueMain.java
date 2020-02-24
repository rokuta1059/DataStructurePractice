package day_10;

import java.util.Scanner;

public class PriorityQueueMain {
	

	public static int getHeight(PriorityQueue<Integer> pq) {
		int i = pq.getSize();
		return (int)(Math.log10(i) / Math.log10(2));
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		String command;
		int data;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a command: e(nqueue), d(equeue), h(eight),\n"
				+ "k(th largerst item), p(rint), pt(print in tree form), or q(uit)");
		while (true) {
			System.out.print("> ");
			command = in.next();
			if (command.equals("e")) {
				data = in.nextInt();
				pq.enqueue(data); 
			}
			else if (command.equals("d")) {
				int item = pq.dequeue();
				System.out.println(item + " removed.");
			}
			else if (command.equals("p")) {
				System.out.print(pq);
			}
			else if (command.equals("k")) {
				int kth = in.nextInt();
				int item = pq.kthLargestItem(kth);
				System.out.println(item);
			}
			else if (command.equals("h")) {
				int height = getHeight(pq);
				System.out.println("Height: " + height);
			}
			else if (command.equals("pt"))
				pq.display();			
			else if (command.equals("q")) {
				System.out.println("Commands terminated.");
				break;
			}
		}
		in.close();
	}


}
