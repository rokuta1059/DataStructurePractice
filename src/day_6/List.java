package day_6;

interface List<T> {
	
	public boolean isEmpty();
	public void insert(T item);
	public int size();
	public String toString();

	public void reset();
	public boolean hasNext();
	public T next();

}
