package tree;

import utility.*;

public class ThreadedTree {
	public static void threadedTraversal(TreeNode root){
		if(root == null)
			return;
		
		TreeNode prev = null, curr = root;
		while(curr != null){
			if(curr.left == null){
				System.out.println(curr.val);
				curr = curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right != null && prev.right != curr){
					prev = prev.right;
				}
				
				if(prev.right == null){
					prev.right = curr;
					curr = curr.left;
				}
				
				else{
					prev.right = null;
					System.out.println(curr.val);
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		threadedTraversal(root);
	}
}
