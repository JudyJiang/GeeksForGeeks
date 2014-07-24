package Tree;

public class BinaryTree<T> {
	public T rootElement;
	public BinaryTree<T> left;
	public BinaryTree<T> right;
	
	public BinaryTree(){
		super();
	}
	
	public BinaryTree(T data){
		this();
		this.rootElement = data;
	}
}
