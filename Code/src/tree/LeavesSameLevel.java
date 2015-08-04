package tree;

import utility.*;
/**
 * Again Love myself
 * @author FengjiaoJiang
 *
 */
public class LeavesSameLevel {
	public static boolean leafSameLevel(TreeNode root){
		return leafSameLevel(root, 0) != -1;
	}
	
	public static int leafSameLevel(TreeNode root, int level){
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null){
			return level;
		}
		
		int leftL = 0, rightL = 0;
		if(root.left != null){
			leftL = leafSameLevel(root.left, level + 1);
			if(leftL == -1)
				return -1;
		}
		if(root.right != null){
			rightL = leafSameLevel(root.right, level + 1);
			if(rightL == -1)
				return -1;
		}
		
		if(leftL == rightL){
			return leftL;
		}
		
		else if(leftL != 0 && rightL != 0 && leftL != rightL)
			return -1;
		
		return leftL == 0 ? rightL : leftL;
	}
	
	
	public static void main(String[] argrs){
		TreeNode root = SampleTrees.root3;
		System.out.println(leafSameLevel(root));
	}
}
