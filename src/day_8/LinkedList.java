package day_8;

public class LinkedList<T> { 
	
	private static class Node<T> {
		
		private T item;
		private Node<T> next;		
		
		private Node() {next = null;}
		
		private Node(T item) {
			this.item = item;
			next = null;
		}
		
		private Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}		
	
	private Node<T> head = null;
	private int size;		
	
	public boolean isEmpty(){
		return size == 0;
	}
	public int size() {
		return size;
	}
	public void clear() {
		head = null;
		size = 0;
	}

	public void print() {		// 재귀로 구현
		print(head);
		System.out.println();
	}

	private void print(Node<T> node) {
		if (node != null) {
			System.out.print(node.item + " ");
			print(node.next);
		}
	}

	public void insertFirst(T item) {	// 맨 앞에 삽입
		head = new Node<T>(item, head);
		size++;
	}
	
	public T getNthItem(int nth)  {		// 리스트의 n번째 항목 반환
		Node<T> scan = head;
		int count = 1;
		if (count == nth) {
			return scan.item;
		}
		else {
			return getNthItem(nth, count + 1, scan.next);
		}
	}
	
	public T getNthItem(int nth, int count, Node<T> node) {
		if(count == nth) {
			return node.item;
		}
		else {
			return getNthItem(nth, count + 1, node.next);
		}
	}
	
	public boolean search(T item) {		// 리스트에 item이 있는지 true/false로 판별
		Node<T> scan = head;
		if (scan.item == item) {
			return true;
		}
		else {
			return search(scan.next, item);
		}
	}
	
	public boolean search(Node<T> node, T item) {
		if(node.item == item) {
			return true;
		}
		else if (node.next == null) {
			return false;
		}
		else {
			return search(node.next, item);
		}
	}
	
	public void insertLast(T item)  {	// 리스트의 맨 끝에 item 삽입
		Node<T> scan = head;
		if(scan == null) {
			head = new Node<T>(item);
			size++;
		}
		else {
			insertLast(scan, item);
		}
	}
	
	public void insertLast(Node<T> node, T item) {
		if(node.next == null) {
			node.next = new Node<T>(item);
			size++;
		}
		else {
			insertLast(node.next, item);
		}
	}
	
	public boolean removeFirst(T item) {	// 리스트에 첫 번째 item을 삭제하고 true 반환, item이
											// 리스트에 없으면 false 반환
		Node<T> curr = head;
		if (curr.item == item) {
			head.next = curr.next;
			size--;
			return true;
		}
		else {
			return removeFirst(curr, curr.next, item);
		}
	}
	
	public boolean removeFirst(Node<T> prev, Node<T> curr, T item) {

		if (curr == null) {
			return false;
		}
		
		else if(curr.item == item) {
			prev.next = curr.next;
			size--;
			return true;
		}
		else {
			return removeFirst(prev.next, curr.next, item);
		}
	}
	
	public boolean removeAll(T item) {	// 리스트에 item을 모두 삭제하고 true 반환, item이
										// 리스트에 없으면 false 반환
		boolean remove = false;
		if(head.item == item) {
			head = head.next;
			size--;
			remove = true;
			return removeAll(item);
		}
		else if(head.next != null) {
			remove = removeAll(head, head.next, item, remove);
		}
		
		return remove;
	}
	
	public boolean removeAll(Node<T> prev, Node<T> curr, T item, boolean remove) {
		if(curr == null && remove == true) 
			return true;
		else if(curr == null && remove == false)
			return false;
		
		if(curr.item == item){
			prev.next = curr.next;
			size--;
			remove = true;
			return removeAll(prev, curr.next, item, remove);
		}
		
		return removeAll(prev.next, curr.next, item, remove);
		
	}
	
	public void reversePrint() {	// 역순으로 출력
		reversePrint(head);
		System.out.println();
	}
	
	public void reversePrint(Node<T> node) {
		if(node != null) {
			reversePrint(node.next);
			System.out.print(node.item + " ");
		}
	}
	
	public LinkedList<T> copy() {	// 역순으로 출력
		LinkedList<T> newList = new LinkedList<T>();
		if (head != null)
			copy(newList, head);
		return newList;
	}
	
	public LinkedList<T> copy(LinkedList<T> newList, Node<T> node) {
		if(node != null) {
			copy(newList, node.next);
			newList.insertFirst(node.item);
		}
		return newList;
	}
}
