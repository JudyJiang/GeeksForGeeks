package tree;

import utility.*;

/**
 * Still love myself
 * @author FengjiaoJiang
 *
 */
public class SumOfLeftLeaves {
	public static int sumLeftLeaves(TreeNode root){
		if(root == null || (root.left == null && root.right == null))
			return 0;
		
		return leftSum(root);
	}
	
	public static boolean isLeaf(TreeNode node){
		if(node == null)
			return false;
		return node.left == null && node.right == null;
	}
	
	public static int leftSum(TreeNode root){
		int res = 0;
		if(root == null)
			return 0;
		if(root.left != null && isLeaf(root.left))
			res += root.left.val;
		
		if(root.left != null)
			res += leftSum(root.left);
		
		if(root.right != null && isLeaf(root.right))
			return res;
		
		else{
			res += leftSum(root.right);
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);
		root.left.right.right = new TreeNode(15);
		root.right = new TreeNode(49);
		root.right.left = new TreeNode(23);
		root.right.right = new TreeNode(52);
		root.right.right.left = new TreeNode(50);
		System.out.println(leftSum(root));
	}
}
