package tree;

import utility.*;

public class RemoveHalfNodes {
	public static TreeNode removeHalfNodes(TreeNode root){
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root;
		
		TreeNode l = removeHalfNodes(root.left);
		TreeNode r = removeHalfNodes(root.right);
		
		if((l != null && r != null) || (l == null && r == null)){
			root.left = l;
			root.right = r;
			return root;
		}
		
		else{
			return l == null ? r : l;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(11);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		TreeNode res = removeHalfNodes(root);
		System.out.println(res.right.left.val);
	}
}
