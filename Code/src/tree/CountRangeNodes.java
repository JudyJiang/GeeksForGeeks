package tree;


import utility.*;

public class CountRangeNodes {
	public static int rangeNodes(TreeNode root, int low, int high){
		if(root == null)
			return 0;
		

		if(root.val <= high && root.val >= low){
			
			return 1 + rangeNodes(root.left, low, high) + rangeNodes(root.right, low, high);
		}
		
		else if(root.val > high){
			return rangeNodes(root.left, low, high);
		}
		
		else
			return rangeNodes(root.right, low, high);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(50);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(100);
		System.out.println(rangeNodes(root, 1, 120));
	}
}
