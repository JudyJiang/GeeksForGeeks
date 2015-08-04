package careercup;

import utility.TreeNode;

public class SecondLargestBST {
	
	public static void secondLargest(TreeNode root){
		if(root == null)
			return ;
		
		TreeNode curr, prev = null, p = root;
		while(p != null){
			if(p.right != null){
				prev = p;
				curr = p.right;
				p = p.right;
			}
			else if(p.left != null){
				prev = p.left;
				p = p.left;
			}
			else
				p = null;
		}
		
		System.out.println(prev.val);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		secondLargest(root);
	}
}
