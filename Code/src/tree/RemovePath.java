package tree;

import utility.*;

public class RemovePath {
	public static TreeNode deletePath(TreeNode root, int k){
		if(root == null || k <= 0)
			return null;
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		int res = remove(root, k);
		
		if(res == -1)
			return null;
		return root;
	}
	
	public static int remove(TreeNode root, int k){
		//System.out.println(root.val + " " + k);
		if(root.left == null && root.right == null && k <= 1)
			return k;
		
		if(root.left == null && root.right == null && k > 1)
			return -1;
		
		int left = 0, right = 0;
		if(root.left != null)
			left = remove(root.left, k-1);
		if(root.right != null)
			right = remove(root.right, k-1);
		//System.out.println(left + " " + right + " " + root.val);
		
		if((left == -1 && right == -1) || (left == 0 && right == -1) || (left == -1 && right == 0)){
			if(root.left != null)
				root.left = null;
			if(root.right != null)
				root.right = null;
			return -1;
		}
		
		if(left == -1){
			root.left = null;
		}
		
		if(right == -1)
			root.right = null;
		
		return k;
	}
	
	public static TreeNode removeNode(TreeNode root, int k){
		return removeNode(root, 1, k);
	}
	
	public static TreeNode removeNode(TreeNode root, int level, int k){
		if(root == null)
			return null;
		
		root.left = removeNode(root.left, level+1, k);
		root.right = removeNode(root.right, level+1, k);
		
		if(root.left == null && root.right == null && level < k)
			return null;
		return root;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		TreeNode res = removeNode(root, 4);
		System.out.println(res.left.right.val);
	}
}
