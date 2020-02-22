package day_9;

class BSTNode<T> {

	public T item;
	public BSTNode<T> left;
	public BSTNode<T> right;
	
	public BSTNode(T item) {  // 생성자
		
		this.item = item;
		left = null;
		right = null;
	}

}
