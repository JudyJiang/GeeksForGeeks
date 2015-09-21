package tree;

import utility.*;

/*
 * Can't figure out another way to do so...
 * Cuase there' no pointer in Java.
 */
public class SubtreeInRange {
	public static int inRangeSubtrees(TreeNode root, int low, int high){
		int[] record = new int[2];
		record[0] = -1;
		record[1] = 0;
		inRangeSubtrees(root, low, high, record);
		return record[1];
	}
	
	
	public static int[] inRangeSubtrees(TreeNode root, int low, int high, int[] recorder){
		if(root == null){
			recorder[0] = 0;
			return recorder;
		}
		
		int l = root.left == null ? 0 : inRangeSubtrees(root.left, low, high, recorder)[0];
		int r = root.right == null ? 0 : inRangeSubtrees(root.right, low, high, recorder)[0];
		
		if(l != - 1 && r != - 1 && root.val <= high && root.val >= low){
			recorder[0] = 0;
			recorder[1] += 1;
			return recorder;
		}
		else{
			recorder[0] = -1;
			return recorder;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(50);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(100);
		System.out.println(inRangeSubtrees(root, 1, 45));
	}
}
