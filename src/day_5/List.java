package day_5;

public interface List<T> {
	
	public boolean isEmpty();
	public void insert(T item);
	public boolean remove(T item);
	public boolean search(T item);
	public int size();
	public String toString();

	public void reset();
	public boolean hasNext();
	public T next();

	public void insert(int num, T item); 	// item을 리스트의 num번째 앞의 노드에 삽입한다
	public void delete(int num);			// 리스트의 num번째 노드를 삭제한다
	public void append(T item);				// item을 리스트의 맨 끝에 삽입한다


}
