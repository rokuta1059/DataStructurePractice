package day_6;

class SortedLinkedList<T extends Comparable<T>> implements List<T> {

	private static class Node<T> {
		private T item;
		private Node<T> next;
		private Node() {
			next = null;
		}
		private Node(T item) {
			this.item = item;
			next = null;
		}
	}
	
	private Node<T> head;
	private Node<T> scanPos;
	private int size;

	// 생성자
	public SortedLinkedList() {
		head = null;
		size = 0;
		scanPos = null;
	}

	/**
	 * 리스트를 초기화한다.
 	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * 리스트가 비어있는지 확인한다.
	 * @return true(리스트가 비어있는 경우)
	 * 		   false(리스트가 비어있지 않는 경우)
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 리스트에 새로운 노드를 추가한다.
	 * @param item 추가할 노드
 */
	@Override
	public void insert(T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> prev = null;
		Node<T> curr = head;
		while (curr != null) {
			if(curr.item.compareTo(item) > 0)
				break;
			else {
				prev = curr;
				curr = curr.next;
			}
		}
		if(prev == null) {
			newNode.next = head;
			head = newNode;
		}
		else {
			newNode.next = curr;
			prev.next = newNode;
		}
		size++;

	}

	/**
	 * 리스트의 크기를 반환한다.
	 * @return 리스트의 크기
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * 탐색자를 초기화한다.
	 */
	@Override
	public void reset() {
		scanPos = head;

	}

	/**
	 * 탐색할 다음 노드가 있는지 확인한다.
	 * @return true(다음 노드가 존재하는 경우)
	 * 		   false(다음 노드가 존재하지 않는 경우)
	 */
	@Override
	public boolean hasNext() {
		return scanPos != null;
	}

	/**
	 * 현재 노드를 반환하고
	 * 다음 노드를 탐색한다.
	 * @return 현재 노드
	 */
	@Override
	public T next() {
		T item = scanPos.item;
		scanPos = scanPos.next;
		return item;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> scan = head;
		while(scan != null) {
			sb.append(scan.item.toString());
			scan = scan.next;
		}
		return sb.toString();
	}
}
