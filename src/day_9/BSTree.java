package day_9;


/**
 * 이진 탐색 트리에서 데이터 삽입/삭제/탐색/출력을 구현한다.
 * 이진 탐색 트리에서 필요한 메소드를 재귀 함수로 구현한다.
 * @param <T>
 */
class BSTree  <T extends Comparable <T>> {

	private BSTNode<T> root;
	private boolean insertSuccess;
	private boolean removeSuccess;

	public BSTree() {
		root = null;
	}	// 생성자
	
	public void insert(T data) {
		root = insert(root, data);
	}	// 삽입
	
	public BSTNode<T> insert (BSTNode<T> node, T data) {
		if(node == null)
			node = new BSTNode<T>(data);
		else if (node.item.compareTo(data) < 0)
			node.right = insert(node.right, data);
		else if (node.item.compareTo(data) > 0)
			node.left = insert(node.left, data);
		return node;
	}
	
	public boolean remove (T data) {	// 삭제
		root = remove(root, data);
		return removeSuccess;
	}
	
	public BSTNode<T> remove (BSTNode<T> node, T data) {
		if(node == null)
			removeSuccess = false;
		else if (node.item.compareTo(data) < 0)
			node.right = remove(node.right, data);
		else if (node.item.compareTo(data) > 0)
			node.left = remove(node.left, data);
		else {
			removeSuccess = true;
			if(node.right == null)
				node = node.left;
			else if(node.left == null)
				node = node.right;
			else {
				BSTNode<T> maxNode = node.left;
				while (maxNode.right != null)
					maxNode = maxNode.right;
				node.item = maxNode.item;
				node.left = remove(node.left, maxNode.item);
			}
		}
		return node;
	}
	
	public boolean search (T data) {
		return search(root, data);
	}	// 탐색
	
	public boolean search (BSTNode<T> node, T data) {
		if(node == null)
			return false;
		else if (node.item.compareTo(data) < 0)
			return search(node.right, data);
		else if (node.item.compareTo(data) > 0)
			return search(node.left, data);
		else
			return true;
	}
	
	public void inorderTraverse() {		// 중위 순회
		inorderTraverse(root);
		System.out.println();
	}
	
	public void inorderTraverse(BSTNode<T> node) {
		if(node != null) {
			inorderTraverse(node.left);
			System.out.print(node.item + " ");
			inorderTraverse(node.right);
		}
	}

	/**
	 * RVL 순회 (오른쪽 서브 트리, 현재 노드, 왼쪽 서브 트리 순서로 순회)하며
	 * 공백 사용하여 출력하도록 한다.
	 * 각 노드에 왼쪽 자식 노드가 있으면 L,
	 * 오른쪽 자식 노드가 있으면 R을 데이터와 함께 출력한다.
	 */
	public String toString() {	// 트리의 구조를 알 수 있도록 출력
		StringBuilder sb = new StringBuilder();
		int count = 0;
		return toString(root, sb, count);
	}
	
	public String toString(BSTNode<T> node, StringBuilder sb, int count) {
		
		if(node.right != null) {
			toString(node.right, sb, count+1);
		}
		
		for(int i = 0; i < count; i++) {
			sb.append("\t");
		}
		sb.append(node.item);
		if(node.left != null)
			sb.append(",L");
		if(node.right != null)
			sb.append(",R");
		sb.append("\n");
		
		if(node.left != null) {
			toString(node.left, sb, count+1);
		}
			
		return sb.toString();	
	}
	
	public int height() {
		return height(root) - 1;
	}	// 트리의 높이
	
	public int height(BSTNode<T> node) {
		if (node == null)
			return 0;
		else {
			int leftheight = height(node.left);
			int rightheight = height(node.right);
			if(leftheight < rightheight)
				return 1 + rightheight;
			else
				return 1 + leftheight;
		}
	}
	
	public int countNodes() {
		return countNodes(root);
	}	// 트리의 노드 수
	
	public int countNodes(BSTNode<T> node) {
		if(node == null)
			return 0;
		else
			return 1 + countNodes(node.left) + countNodes(node.right);
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}	// 트리의 리프 노드 수
	
	public int countLeaves(BSTNode<T> node) {
		
		if (node == null)
			return 0;
		else if(node.left == null && node.right == null)
			return 1; 
		else
			return countLeaves(node.left) + countLeaves(node.right);
	}
}
