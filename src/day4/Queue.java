package day4;

interface Queue<T> {

	public void enqueue(T item);
	public T dequeue();
	public T peek();
	public boolean isEmpty();
	public int size();
}
