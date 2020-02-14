package day_7;

interface List<T> {

	public boolean isEmpty();
	public void insert(T item);
	public boolean remove(T item);
	public boolean search(T item);
	public int size();

}
