package tree;

import java.util.ArrayList;
public class RootLeafPaths {
	
	public static void GetAllPaths(BinaryTree root){
		ArrayList container = new ArrayList();
		GetAllPaths(root, container);
	}
	
	public static void GetAllPaths(BinaryTree root, ArrayList container){
		if(root == null)
			return ;
		if(root.left == null && root.right == null){
			container.add(root.rootElement);
			PrintArray(container);
			container.remove(container.size() - 1);
			return ;
		}
		
		container.add(root.rootElement);
		GetAllPaths(root.left, container);
		GetAllPaths(root.right, container);
		container.remove(container.size() - 1);
	}
	
	public static void PrintArray(ArrayList arr){
		for(Object o : arr)
			System.out.print(o.toString() + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		BinaryTree root = new BinaryTree(10);
		root.left = new BinaryTree(8);
		root.right = new BinaryTree(2);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(2);
		GetAllPaths(root);
	}
}
