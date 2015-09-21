 package tree;

import utility.*;
/**
 * Finally a recursively way for the tree smallest node.
 * And for additional staff I love myself
 * @author FengjiaoJiang
 *
 */
public class KLargestNodeBST {
	public static void kSmallest(TreeNode root, int k){
		if(root == null || k <= 0)
			return ;
		
		int count = 0;
		kSmallestUtil(root, k, count);
	}
	
	public static int kSmallestUtil(TreeNode root, int k, int count){
		if(root == null)
			return count;
		
		int l = kSmallestUtil(root.left, k, count);
		if(l + 1 == k)
			System.out.println(root.val);
		int r = kSmallestUtil(root.right, k, l + 1);
		return r;
	}
	
	
	
	//if asked for return instead of print the value, use additional structure such as array 
	//to hold information
	public static void kLargestElement(TreeNode root, int k){
		if(root == null || k <= 0)
			return ;
		
		int count = 0;
		kLargestUtil(root, k, count);
	}
	
	public static int kLargestUtil(TreeNode root, int k, int count){
		if(root == null)
			return count;
		
		int r = kLargestUtil(root.right, k, count);
		if(r + 1 == k)
			System.out.println(root.val);
		int l = kLargestUtil(root.left, k, r + 1);
		return l;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		kLargestElement(root, 5);
	}
}
