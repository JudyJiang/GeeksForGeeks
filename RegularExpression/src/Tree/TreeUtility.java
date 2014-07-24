package Tree;

import java.util.*;

public class TreeUtility {
	static private BinaryTree sampleTree = new BinaryTree(8);
	
	static {
		sampleTree.left = new BinaryTree(5);
		sampleTree.right = new BinaryTree(4);
		sampleTree.left.left = new BinaryTree(9);
		sampleTree.left.right = new BinaryTree(7);
		sampleTree.left.right.left = new BinaryTree(1);
		sampleTree.left.right.right = new BinaryTree(12);
		sampleTree.left.right.right.left = new BinaryTree(2);
		
		sampleTree.right.right = new BinaryTree(11);
		sampleTree.right.right.left = new BinaryTree(3);    
	}
	/*
	 * This seems very important for java generic part
	 */
	
	/**
	 * Build a binary tree from sorted array
	 * @param array
	 * @return
	 */
	public static <T> BinaryTree TreeFromArray(T[] array){
		if(array == null || array.length == 0)
			return null;
		
		BinaryTree root = TreeFromArray(array, 0, array.length - 1);
		
		return root;
	}
	
	public static <T> BinaryTree TreeFromArray(T[] array, int left, int right){
		if(left > right)
			return null;
		
		int mid = (left + right) / 2;
		BinaryTree root = new BinaryTree(array[mid]);
		
		root.left = TreeFromArray(array, left, mid - 1);
		root.right = TreeFromArray(array, mid + 1, right);
		
		return root;
	}
	
	/**(simple version is the print, not return a list;
	 * Return a list of value from in-order tree traverse. 
	 * Both recursively or iteratively (print or return a list)
	 * @param root
	 * @return
	 */
	public static void TraverseTreeInorder(BinaryTree root){
		if(root == null)
			return ;
		
		TraverseTreeInorder(root.left);
		System.out.println(root.rootElement);
		TraverseTreeInorder(root.right);
	}
	
	/*This can be easily changed to List<T> version.*/
	public static void TraverseTreeInorderNonRecursive(BinaryTree root){
		if(root == null)
			return ;
		
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		stack.push(root);
		
		boolean visited = false;
		while(!stack.isEmpty()){
			BinaryTree top = stack.peek();
			
			if(top == null){
				stack.pop();
				visited = true;
			}
			
			else if(visited){
				BinaryTree node = stack.pop();
				stack.push(node.right);
				System.out.print(node.rootElement + " ");
				visited = false;
			}
			
			else{
				stack.push(top.left);
			}
		}
	}
	
	
	public static void TraverseTreePreOrder(BinaryTree root){
		
	}
	
	public static void TraverseTreePreOrderNonRecursive(BinaryTree root){
		
	}
	
	
	/**
	 * It's the level order traverse of a tree
	 * @param root
	 */
	public static void TraverseTreeLeverOrder(BinaryTree root){
		if(root == null)
			return ;
		
		//Queue<BinaryTree> queue = new PriorityQueue<BinaryTree>();
		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);
		
		while(true){
			BinaryTree top = queue.peek();
			
			if(top == null){
				queue.poll();
				if(queue.isEmpty())
					break;
			}
			
			System.out.print(top.rootElement + " ");
			if(top.left != null)
				queue.add(top.left);
			if(top.right != null)
				queue.add(top.right);
			queue.remove();
		}
	}
	
	
	public static void main(String[] args){
		Integer[] array = {1, 2, 3, 4, 5};
		BinaryTree root = TreeUtility.TreeFromArray(array);
		TreeUtility.TraverseTreeLeverOrder(TreeUtility.sampleTree);
	}

}
