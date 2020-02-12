package day_4;

/**
 * Queue의 상속 클래스
 * @author 김우섭
 *
 * @param <T>
 */
class ArrayQueue<T> implements Queue<T> {
	
	private T[] items;
	private int front;
	private int rear;
	private int size;
	private int maxSize;
	
	public ArrayQueue() {
		this(10);
	}

	/**
	 * 생성자
	 * @param max Queue의 최대 크기
	 */
	public ArrayQueue(int max) {
		maxSize = max;
		items = (T[]) new Object[maxSize];
		size = 0;
		front = 0;
		rear = maxSize - 1;
	}

	/**
	 * Queue에 새로운 값을 추가한다.
	 * @param item 추가하려는 값
	 */
	public void enqueue(T item) {
		if(isFull()) {
			resize();
		}
		rear = (rear + 1) % maxSize;
		items[rear] = item;
		size++;
	}

	/**
	 * Queue에 들어온 가장 첫번째 값을 반환하고
	 * Queue에서 제거한다.
	 * @return 반환된 값
	 */
	public T dequeue() {
		if(isEmpty()) 
			throw new java.util.NoSuchElementException("dequeue(): queue empty");
		T item = items[front];
		front = (front + 1) % maxSize;
		size--;
		return item;
	}

	/**
	 * Queue의 가장 첫번째 값을 보여준다.
	 * @return Queue의 가장 첫번째 값
	 */
	public T peek() {
		if(isEmpty()) 
			throw new java.util.NoSuchElementException("peek(): queue empty");
		return items[front];
	}

	/**
	 * Queue가 비어있는지 확인한다.
	 * @return true(Queue가 비어있는 경우), false(Queue가 비어있지 않은 경우)
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Queue의 현재 크기를 반환한다.
	 * @return Queue의 현재 크기
	 */
	public int size() {
		return size;
	}

	/**
	 * Queue가 가득 차 있는지 확인한다.
	 * @return true(Queue가 가득 찬 경우), false(Queue가 가득 차지 않은 경우)
	 */
	private boolean isFull() {
		return size == maxSize;
	}

	/**
	 * 배열의 사이즈를 두 배로 늘린다.
	 */
	private void resize() {
		T[] newItems = (T[])new Object[maxSize * 2];
		int j = front;
		for(int i = 0; i < size; i++) {
			newItems[i] = items[j];
			j = (j + 1) % maxSize;
		}
		items = newItems;
		front = 0;
		rear = size - 1;
		maxSize = 2 * maxSize;
	}

	/**
	 * Queue의 출력값을 정의한다.
	 * @return
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		T[] scan = items;
		int j = front;
		int i = (rear + 1) % maxSize;
		while(j != i) {
			sb.append(scan[j] + " ");
			j = (j + 1) % maxSize;
		}
		return sb.toString();
	}

}
