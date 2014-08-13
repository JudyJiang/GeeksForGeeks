package tree;

import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> implements Comparator<T>{
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

	@Override
	public int compare(T a, T b) {
		
		return 0;
	}
}
