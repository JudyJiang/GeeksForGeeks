package tree;


import utility.*;

public class DoubleTree {
	public static void doubleTree(TreeNode root){
		if(root == null)
			return;
		
		TreeNode left = root.left;
		TreeNode rootCopy = new TreeNode(root.val);
		rootCopy.left = left;
		root.left = rootCopy;
		doubleTree(left);
		doubleTree(root.right);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		doubleTree(root);
		System.out.println(root.left.left.left.val);
	}
}
