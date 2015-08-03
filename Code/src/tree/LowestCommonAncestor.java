package tree;

import utility.*;
public class LowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return null;
		
		if(p == null || q == null || root == p || root == q)
			return root;
		
		boolean pOnLeft = findNode(root.left, p);
		boolean qOnLeft = findNode(root.left, q);
		System.out.println(pOnLeft + " " + qOnLeft);
		if(pOnLeft != qOnLeft){
			return root;
		}
		
		TreeNode remain = pOnLeft? root.left : root.right;
		return lowestCommonAncestor(remain, p, q);
	}
	
	public static boolean findNode(TreeNode root, TreeNode node){
		if(root == null && node == null)
			return true;
		
		if((root == null && node != null))
			return false;
		
		if(root == node) 
			return true;
		
		return findNode(root.left, node) || findNode(root.right, node);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).val);
	}
}
