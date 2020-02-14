package day_7;

public interface Iterator<T> {

	public boolean hasNext();
	public T next();
	public void remove();
}
