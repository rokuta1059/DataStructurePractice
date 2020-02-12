package day_5;

import java.util.NoSuchElementException;

/**
 * 정렬되지 않은 LinkedList 구현
 * @param <T>
 */
public class UnsortedLinkedList<T> implements List<T> {
	
	private static class Node<T> {
		private T item;
		private Node<T> next;

		private Node() {};

		private Node(T item) {
			this(item, null);
		}

		private Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
		
	}
	
	private Node<T> head;
	private Node<T> scanPos;
	private int size;

	public UnsortedLinkedList() {
		head = null;
		size = 0;
		scanPos = null;
	}

	/**
	 * 리스트가 비어있는지 확인한다.
	 * @return true(리스트가 비어있는 경우),
	 * 		   false(리스트가 비어있지 않는 경우)
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 리스트에 노드를 추가한다.
	 * @param item 추가할 노드
	 */
	@Override
	public void insert(T item) {
		Node<T> newNode = new Node(item, null);
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
		size++;
	}

	/**
	 * 리스트에서 노드를 제거한다
	 * @param item 제거할 노드
	 * @return true(제거에 성공한 경우)
	 * 		   false(제거에 실패한 경우)
	 */
	@Override
	public boolean remove(T item) {
		if(isEmpty())
			throw new NoSuchElementException("remove(): list empty");
		Node<T> prev = null;
		Node<T> curr = head;

		// 리스트를 탐색하여 노드를 확인한다.
		while (curr != null) {
			if(curr.item.equals(item))
				break;
			else {
				prev = curr;
				curr = curr.next;
			}
		}
		if(curr == null)
			return false;
		else if (prev == null)
			head = head.next;
		else
			prev.next = curr.next;
		size--;
		return true;
	}

	/**
	 * 리스트에서 해당 노드가 존재하는지 확인한다.
	 * @param item 확인할 노드
	 * @return true(해당 노드가 존재할 경우)
	 * 		   false(해당 노드가 존재하지 않을 경우)
	 */
	@Override
	public boolean search(T item) {
		if(isEmpty())
			throw new NoSuchElementException("search(): list empty");
		Node<T> tmp = head;
		while(tmp != null) {
			if (tmp.item.equals(item))
				return true;
			else
				tmp = tmp.next;
		}
		return false;
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
	 * 리스트 탐색 포인터를 초기로 되돌린다.
	 */
	@Override
	public void reset() {
		scanPos = head;

	}

	/**
	 * 탐색 포인터가 탐색 가능한 다음 노드가 있는지 확인한다.
	 * @return true(다음 노드가 있는 경우)
	 * 		   falue(다음 노드가 없는 경우)
	 */
	@Override
	public boolean hasNext() {
		return scanPos != null;
	}

	/**
	 * 포인터가 가리키고 있는 노드를 반환하고
	 * 다음 노드로 이동한다.
	 * @return 포인터가 가리키고 있는 노드값
	 */
	@Override
	public T next() {
		T item = scanPos.item;
		scanPos = scanPos.next;
		return item;
	}

	/**
	 * 리스트의 입력받은 위치에 노드를 추가한다.
	 * @param num 노드를 추가할 위치
	 * @param item 추가할 노드
	 */
	@Override
	public void insert(int num, T item) {
		Node<T> newNode = new Node(item, null);
		Node<T> curr = head;
		Node<T> prev = null;
		
		for(int i = 0; i < num - 1; i++) {
			prev = curr;
			curr = curr.next;
		}
		if (num == 1) {
			newNode.next = head;
			head = newNode;
		}
		else if (curr == null) {
			prev.next = newNode;
		}
		else {
			newNode.next = curr;
			prev.next = newNode;
		}
		size++;

	}

	/**
	 * 리스트의 지정된 위치의 노드를 삭제한다.
	 * @param num 노드를 삭제시킬 위치
	 */
	@Override
	public void delete(int num) {
		if(isEmpty())
			throw new NoSuchElementException("remove(): list empty");
		Node<T> prev = null;
		Node<T> curr = head;
		for (int i = 0; i < num - 1; i++) {
			prev = curr;
			curr = curr.next;
		}
		if(curr == null)
			prev.next = null;
		else if (prev == null)
			head = head.next;
		else
			prev.next = curr.next;
		size--;

	}

	/**
	 * 리스트의 맨 끝에 노드를 추가한다
	 * @param item 추가할 노드
	 */
	@Override
	public void append(T item) {
		Node<T> newNode = new Node<T>(item, null);
		Node<T> search = head;
		while(search.next != null) {
			search = search.next;
		}
		search.next = newNode;
		size++;

	}

	/**
	 * 출력을 설정한다.
	 * @return 출력값
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> scan = head;
		while (scan != null) {
			sb.append(scan.item + " ");
			scan = scan.next;
		}
		return sb.toString();
	}
	
	
	
}
