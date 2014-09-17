package linkedlist;

import tree.BinaryTree;
import tree.TreeUtility;

public class GreatTreeRecurson {
	private static BinaryTree<Integer> root = new BinaryTree<Integer>();
	static{
		root = TreeUtility.TreeFromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	}
	
	public DoubleListNode TreeToList(BinaryTree<Integer> root){
		return null;// hdfs$
	}
	
	public static void main(String[] args){
		TreeUtility.TraverseTreeLeverOrder(root);
	}
}
